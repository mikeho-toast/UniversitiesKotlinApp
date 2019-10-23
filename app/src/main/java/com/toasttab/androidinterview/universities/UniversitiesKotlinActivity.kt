package com.toasttab.androidinterview.universities

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.toasttab.androidinterview.R
import com.toasttab.androidinterview.app.BaseDaggerAppCompatActivity
import com.toasttab.androidinterview.app.RecyclerAdapter
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

    private lateinit var presenter: UniversitiesContract.UniversitiesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_universities)
        setTitle(R.string.universities_kotlin_activity)


        viewManager = LinearLayoutManager(this)
        presenter = UniversitiesKotlinActivityPresenter(this)
        presenter.loadUniversities(universitiesService)
    }

    /**
     * Display university to view
     */
    override fun bindUniversities(universities: List<University>) {
        //apply is for . short hand
        recyclerView = findViewById<RecyclerView>(R.id.universitiesList).apply {
            adapter = RecyclerAdapter(universities) { university: University -> navigateToWebView(university) }
            setHasFixedSize(true)
            layoutManager = viewManager
        }
    }

    /**
     * The onClick method which retrieves the url link, name of school and country of the school
     */
    override fun navigateToWebView(university: University) {  //onClick Action
        Toast.makeText(this, "Clicked: ${university.name}", Toast.LENGTH_LONG).show()
        val intent = Intent(this, UniversityWebPageActivity::class.java)
        intent.putExtra("Domains", university.domains[0])
        intent.putExtra("Name", university.name)
        intent.putExtra("Country", university.country)

        startActivity(intent)
    }
}


