package com.base.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Burak Eregar on 23.05.2017.
 * burakeregar@gmail.com
 * https://github.com/burakeregar
 */
@Module
class RetrofitModule {
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit = Retrofit.Builder().baseUrl("https://api.nasa.gov/mars-photos/api/v1/")
            .addConverterFactory(GsonConverterFactory.create()).build()
}