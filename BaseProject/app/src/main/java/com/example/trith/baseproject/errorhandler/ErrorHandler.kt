package com.example.trith.baseproject.errorhandler

/**
 * Created by tri.th on 28/08/2018.
 */
interface ErrorHandler {
    fun proceed(e:Throwable)
    fun attachView(view: CanShowError)
    fun dettachView()
}