package com.base.mvp

/**
 * Created by Burak Eregar on 20.05.2017.
 * burakeregar@gmail.com
 * https://github.com/burakeregar
 */
interface BaseView {
    fun onError()
    fun setPresenter(presenter: BasePresenter<*>)
}