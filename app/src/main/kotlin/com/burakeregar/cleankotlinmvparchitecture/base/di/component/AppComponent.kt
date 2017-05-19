package com.burakeregar.cleankotlinmvparchitecture.base.di.component

import android.app.Application
import android.content.res.Resources
import com.burakeregar.cleankotlinmvparchitecture.base.di.module.AppModule
import com.google.gson.Gson
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Burak Eregar on 19.05.2017.
 * burakeregar@gmail.com
 * https://github.com/burakeregar
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun application(): Application
    fun gson(): Gson
    fun resources(): Resources
}