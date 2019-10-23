package com.toasttab.androidinterview.universities

import android.content.Intent
import android.support.v7.app.ActionBar
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.toasttab.androidinterview.R

class UniversitiesWebPagePresenter(mWebView: UniversityWebPageContract.UniversitiesWebPageView) :
    UniversityWebPageContract.UniversitiesWebPagePresenter {
    private lateinit var intent: Intent
    private lateinit var supportActionBar: ActionBar
    private var myWebView: UniversityWebPageContract.UniversitiesWebPageView = mWebView
}