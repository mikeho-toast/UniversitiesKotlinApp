package com.toasttab.androidinterview.app

import dagger.android.support.DaggerApplication

class AndroidInterviewApplication : DaggerApplication() {

    override fun applicationInjector() =
        DaggerAppComponent.builder()
        .application(this)
        .build()

}