package com.toasttab.androidinterview.app

import android.app.Activity
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import com.toasttab.androidinterview.R
import com.toasttab.androidinterview.universities.UniversitiesJavaActivity
import com.toasttab.androidinterview.universities.UniversitiesKotlinActivity

class Navigator(private val activity: Activity) {

    fun onCreateOptionsMenu(menu: Menu?) {
        if (menu == null) {
            return
        }

        menu.add(Menu.CATEGORY_SYSTEM, R.id.universitiesKotlinActivity, 0, R.string.universities_kotlin_activity)
        menu.add(Menu.CATEGORY_SYSTEM, R.id.universitiesJavaActivity, 0, R.string.universities_java_activity)
    }

    fun onOptionsItemSelected(item: MenuItem?) {
        if (item == null) {
            return
        }

        val toClass = when (item.itemId) {
            R.id.universitiesKotlinActivity -> UniversitiesKotlinActivity::class.java
            R.id.universitiesJavaActivity -> UniversitiesJavaActivity::class.java
            else -> return
        }

        if (activity.javaClass != toClass) {
            activity.startActivity(Intent(activity, toClass))
            activity.finish()
        }
    }

}