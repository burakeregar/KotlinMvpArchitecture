package com.burakeregar.kotlinmvparchitecture.home.di

import com.base.di.ActivityScope
import com.burakeregar.kotlinmvparchitecture.api.Endpoints
import com.burakeregar.kotlinmvparchitecture.home.presenter.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {

    @Provides
    @ActivityScope
    internal fun providesHomePresenter(api: Endpoints): HomePresenter {
        return HomePresenter(api)
    }
}
