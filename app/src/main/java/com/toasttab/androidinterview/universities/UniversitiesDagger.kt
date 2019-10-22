package com.toasttab.androidinterview.universities

import android.app.Activity
import com.toasttab.androidinterview.app.ActivityScope
import com.toasttab.androidinterview.app.BaseActivityModule
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named

@Module
class UniversitiesKotlinActivityModule : BaseUniversitiesActivityModule<UniversitiesKotlinActivity>()

@Module
class UniversitiesJavaActivityModule : BaseUniversitiesActivityModule<UniversitiesJavaActivity>()

@Module
abstract class BaseUniversitiesActivityModule<in T : Activity> : BaseActivityModule<T>() {

    @ActivityScope
    @Provides
    @Named("Universities")
    fun providesUniversitiesRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://universities.hipolabs.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }

    @ActivityScope
    @Provides
    fun providesUniversitiesService(@Named("Universities") retrofit: Retrofit) : UniversitiesService {
        return retrofit.create(UniversitiesService::class.java)
    }

}