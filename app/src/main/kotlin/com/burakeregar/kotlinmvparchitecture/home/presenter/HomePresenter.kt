package com.burakeregar.kotlinmvparchitecture.home.presenter

import com.base.mvp.BasePresenter
import com.burakeregar.kotlinmvparchitecture.api.Endpoints
import com.burakeregar.kotlinmvparchitecture.home.model.MarsPhotos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class HomePresenter @Inject constructor(var api: Endpoints) : BasePresenter<HomeView>() {

    fun getMarsPhotos(){
        api.getMarsPhotos().enqueue(object : Callback<MarsPhotos> {
            override fun onResponse(call: Call<MarsPhotos>, response: Response<MarsPhotos>) {
                view?.addPhotos(response.body())
            }
            override fun onFailure(call: Call<MarsPhotos>, t: Throwable) {
                view?.onError()
            }
        })
    }
}