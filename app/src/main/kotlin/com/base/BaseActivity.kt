package com.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.base.di.component.AppComponent
import com.base.mvp.BaseView

/**
 * Created by Burak Eregar on 20.05.2017.
 * burakeregar@gmail.com
 * https://github.com/burakeregar
 */
abstract class BaseActivity: AppCompatActivity(), BaseView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onActivityInject()
    }

    protected abstract fun onActivityInject()

    fun getAppcomponent(): AppComponent = App.appComponent

}
