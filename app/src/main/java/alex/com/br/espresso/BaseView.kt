package com.istimple.akee.util.mvp

interface BaseView<out T : BasePresenter<*>> {

    val presenter: T

}