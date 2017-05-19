package com.burakeregar.cleankotlinmvparchitecture.base

import android.app.Application
import com.burakeregar.cleankotlinmvparchitecture.base.di.component.AppComponent
import com.burakeregar.cleankotlinmvparchitecture.base.di.component.DaggerAppComponent
import com.burakeregar.cleankotlinmvparchitecture.base.di.module.AppModule

/**
 * Created by Burak Eregar on 19.05.2017.
 * burakeregar@gmail.com
 * https://github.com/burakeregar
 */
class App: Application() {

    companion object{
       @JvmStatic lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}