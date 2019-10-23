package com.toasttab.androidinterview.universities

import android.webkit.WebView

class UniversityWebPageContract {

    interface UniversitiesWebPageView { //UI Stuff
        fun displayWebPage(myWebView: WebView, universityLink: String)
    }

    interface UniversitiesWebPagePresenter { //Business Logic
    }
}