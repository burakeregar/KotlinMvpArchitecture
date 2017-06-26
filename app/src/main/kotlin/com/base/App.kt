package com.base

import android.app.Application
import com.base.di.component.AppComponent
import com.base.di.component.DaggerAppComponent
import com.base.di.module.AppModule
import com.facebook.drawee.backends.pipeline.Fresco

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
        Fresco.initialize(this)
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

}