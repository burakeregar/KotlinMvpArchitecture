package com.base.di.component

import android.app.Application
import android.content.res.Resources
import com.base.di.module.ApiModule
import com.base.di.module.AppModule
import com.base.di.module.OkHttpModule
import com.base.di.module.RetrofitModule
import com.base.helper.SpHelper
import com.burakeregar.kotlinmvparchitecture.api.Endpoints
import com.google.gson.Gson
import dagger.Component
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Burak Eregar on 19.05.2017.
 * burakeregar@gmail.com
 * https://github.com/burakeregar
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, RetrofitModule::class, ApiModule::class, OkHttpModule::class))
interface AppComponent {
    fun application(): Application
    fun gson(): Gson
    fun resources(): Resources
    fun retrofit():Retrofit
    fun endpoints():Endpoints
    fun cache(): Cache
    fun client(): OkHttpClient
    fun loggingInterceptor(): HttpLoggingInterceptor
    fun spHelper(): SpHelper
}