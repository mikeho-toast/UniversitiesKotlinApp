package com.toasttab.androidinterview.app

import android.view.Menu
import android.view.MenuItem
import com.toasttab.androidinterview.universities.University
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseDaggerAppCompatActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        navigator.onCreateOptionsMenu(menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        navigator.onOptionsItemSelected(item)
        return super.onOptionsItemSelected(item)
    }

    abstract fun navigateToWebView(university: University)
}