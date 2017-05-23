package com.base.mvp

/**
 * Created by Burak Eregar on 22.05.2017.
 * burakeregar@gmail.com
 * https://github.com/burakeregar
 */
interface Presenter<V : BaseView> {

    fun attachView(view: V)

    fun detachView()
}