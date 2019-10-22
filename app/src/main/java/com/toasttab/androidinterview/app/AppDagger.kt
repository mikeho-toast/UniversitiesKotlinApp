package com.toasttab.androidinterview.app

import android.app.Activity
import android.app.Application
import com.toasttab.androidinterview.universities.UniversitiesJavaActivity
import com.toasttab.androidinterview.universities.UniversitiesJavaActivityModule
import com.toasttab.androidinterview.universities.UniversitiesKotlinActivity
import com.toasttab.androidinterview.universities.UniversitiesKotlinActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Scope
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBuilder::class])
interface AppComponent : AndroidInjector<AndroidInterviewApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder

        fun build() : AppComponent
    }

}

@Retention(AnnotationRetention.RUNTIME)
@Scope
annotation class ActivityScope

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = [UniversitiesKotlinActivityModule::class])
    internal abstract fun bindUniversitiesKotlinActivity(): UniversitiesKotlinActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [UniversitiesJavaActivityModule::class])
    internal abstract fun bindUniversitiesJavaActivity(): UniversitiesJavaActivity
}

@Module
abstract class BaseActivityModule<in T : Activity> {

    @ActivityScope
    @Provides
    fun providesNavigator(activity: T) : Navigator {
        return Navigator(activity)
    }

}