package com.toasttab.androidinterview.universities

class UniversityWebPageContract {
    interface UniversitiesWebPageView { //UI Stuff
        fun displayWebPage()
    }

    interface UniversitiesWebPagePresenter { //Business Logic
        fun loadWebPage()
    }
}