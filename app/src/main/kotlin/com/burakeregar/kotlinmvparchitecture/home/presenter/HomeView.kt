package com.burakeregar.kotlinmvparchitecture.home.presenter

import com.base.mvp.BaseView
import com.burakeregar.kotlinmvparchitecture.home.model.MarsPhotos

interface HomeView : BaseView {
    fun addPhotos(photos: MarsPhotos)
}
