package com.base.di.module

import android.app.Application
import android.content.res.Resources
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
    fun providesGson(): Gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()

    @Provides
    @Singleton
    fun providesApplication(): Application = application

    @Provides
    @Singleton
    fun providesResources(): Resources = application.resources


}