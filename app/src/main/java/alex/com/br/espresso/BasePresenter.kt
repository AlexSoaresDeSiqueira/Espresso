package com.istimple.akee.util.mvp

interface BasePresenter<T> {

    fun stop()

    var view: T
}