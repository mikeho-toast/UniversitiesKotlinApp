package com.toasttab.androidinterview.universities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.toasttab.androidinterview.R

class UniversityWebPageActivity : AppCompatActivity(), UniversityWebPageContract.UniversitiesWebPageView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_university_web_page)
        val universityLink: String = intent.getStringExtra("Domains")
        val universityTitleName: String = intent.getStringExtra("Name")
        val universityCountry: String = intent.getStringExtra("Country")
        val actionBar: ActionBar? = supportActionBar
        actionBar?.title = "$universityTitleName | Country: $universityCountry"
        actionBar?.setDisplayHomeAsUpEnabled(true)
        val myWebView: WebView = findViewById(R.id.web_view)
        myWebView.webViewClient = object : WebViewClient() {
            @SuppressWarnings
            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
            }
        }
        myWebView.loadUrl("http://$universityLink")
    }

    override fun displayWebPage(myWebView: WebView, universityLink: String) {
        myWebView.webViewClient = object : WebViewClient() {
            @SuppressWarnings
            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
            }
        }
        myWebView.loadUrl("http://$universityLink")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
