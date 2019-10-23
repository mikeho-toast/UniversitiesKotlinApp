package com.toasttab.androidinterview.universities

class UniversitiesContract {

    interface UniversitiesView { //UI Stuff
        fun bindUniversities(universities: List<University>)
        fun navigateToWebView(university: University)
    }

    interface UniversitiesPresenter { //Business Logic
        fun loadUniversities(universitiesService: UniversitiesService)
    }
}