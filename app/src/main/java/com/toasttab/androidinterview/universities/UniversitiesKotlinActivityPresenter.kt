package com.toasttab.androidinterview.universities

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UniversitiesKotlinActivityPresenter(mView: UniversitiesContract.UniversitiesView):
    UniversitiesContract.UniversitiesPresenter {
    private var universitiesView: UniversitiesContract.UniversitiesView = mView

    init {
        universitiesView.bindUniversities()
    }

    override fun loadUniversities(universitiesService: UniversitiesService) {
        val call = universitiesService.listUniversities()

        call.enqueue(object : Callback<List<University>> {
            override fun onFailure(call: Call<List<University>>, t: Throwable) {
                Log.v("retrofit", "call failed")
            }

            override fun onResponse(call: Call<List<University>>, response: Response<List<University>>) {
                val responseBody = response.body()
            }
        })
    }
}