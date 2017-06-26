package com.burakeregar.kotlinmvparchitecture.api

import com.burakeregar.kotlinmvparchitecture.home.model.MarsPhotos
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Burak Eregar on 23.05.2017.
 * burakeregar@gmail.com
 * https://github.com/burakeregar
 */
interface Endpoints {
    @GET("rovers/curiosity/photos?sol=50&page=5&api_key=DEMO_KEY")
    fun getMarsPhotos(): Call<MarsPhotos>
}