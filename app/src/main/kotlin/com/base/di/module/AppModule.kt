package com.base.di.module

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.base.helper.SpHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import com.google.gson.Gson;
import com.google.gson.GsonBuilder

/**
 * Created by Burak Eregar on 19.05.2017.
 * burakeregar@gmail.com
 * https://github.com/burakeregar
 */
@Module
class AppModule(val application: Application) {

    @Provides
    @Singleton
    fun providesGson() = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()

    @Provides
    @Singleton
    fun providesApplication() = application

    @Provides
    @Singleton
    fun providesResources() = application.resources

    @Provides
    @Singleton
    fun providesSharedPref(gson: Gson) = SpHelper(application.getSharedPreferences("Sp", Context.MODE_PRIVATE), gson)


}