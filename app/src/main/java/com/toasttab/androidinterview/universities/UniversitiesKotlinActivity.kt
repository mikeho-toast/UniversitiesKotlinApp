package com.toasttab.androidinterview.universities

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.toasttab.androidinterview.R
import com.toasttab.androidinterview.app.BaseDaggerAppCompatActivity
import com.toasttab.androidinterview.app.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_universities.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

//how to set a web view url in android 🌐️🌇️✅
//how to pass in data to a new activity ➡️🧀✅
//how to launch a new activity in kotlin 🚀🍞✅
//how to set a click listener on a recycler view ♻️🌇️✅

class UniversitiesKotlinActivity : BaseDaggerAppCompatActivity(), UniversitiesContract.UniversitiesView {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager
    @Inject
    lateinit var universitiesService: UniversitiesService

    private var presenter: UniversitiesContract.UniversitiesPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_universities)
        setTitle(R.string.universities_kotlin_activity)


        viewManager = LinearLayoutManager(this)
        presenter = UniversitiesKotlinActivityPresenter(this)
    }

    override fun bindUniversities() {
        val call = universitiesService.listUniversities()

        call.enqueue(object : Callback<List<University>> {
            override fun onFailure(call: Call<List<University>>, t: Throwable) {
                Log.v("retrofit", "call failed")
            }

            override fun onResponse(call: Call<List<University>>, response: Response<List<University>>) {
                val responseBody = response.body()
                if (responseBody != null) {
                    universitiesList.adapter =
                        RecyclerAdapter(responseBody) { university: University -> navigateToWebView(university) } //
                }
            }
        })
        recyclerView = findViewById<RecyclerView>(R.id.universitiesList).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
        }
    }

    override fun navigateToWebView(university: University) {  //onClick Action
        Toast.makeText(this, "Clicked: ${university.name}", Toast.LENGTH_LONG).show()
        val intent = Intent(this, UniversityWebPageActivity::class.java)
        intent.putExtra("Domains", university.domains[0])
        intent.putExtra("Name", university.name)
        intent.putExtra("Country", university.country)

        startActivity(intent)
    }
}


