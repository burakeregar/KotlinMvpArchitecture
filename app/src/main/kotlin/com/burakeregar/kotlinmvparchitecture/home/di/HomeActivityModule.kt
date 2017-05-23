package com.burakeregar.kotlinmvparchitecture.home.di

import android.content.Context

import com.base.di.ActivityScope
import com.burakeregar.kotlinmvparchitecture.api.Endpoints
import com.burakeregar.kotlinmvparchitecture.home.HomeActivity
import com.burakeregar.kotlinmvparchitecture.home.presenter.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule(private val homeActivity: HomeActivity) {

    @Provides
    @ActivityScope
    internal fun providesHomeActivity(): HomeActivity {
        return homeActivity
    }

    @Provides
    @ActivityScope
    internal fun providesContext(): Context {
        return homeActivity
    }

    @Provides
    @ActivityScope
    internal fun providesHomePresenter(api: Endpoints): HomePresenter {
        return HomePresenter(api)
    }

}
