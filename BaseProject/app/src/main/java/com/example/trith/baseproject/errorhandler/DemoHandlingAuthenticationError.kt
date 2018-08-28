package com.example.trith.baseproject.errorhandler

import com.example.trith.baseproject.common.weak
import com.example.trith.baseproject.exception.AuthenticationFailureException
import java.lang.ref.WeakReference
import javax.inject.Inject

/**
 * Created by tri.th on 28/08/2018.
 */
class DemoHandlingAuthenticationError @Inject constructor(private val defaultErrorHandler: DefaultErrorHandler)
    : ErrorHandler {

    private lateinit var view:WeakReference<CanShowAuthenticationError>
    override fun proceed(e: Throwable) {
        when(e){
            is AuthenticationFailureException -> doSomeThing()
            else -> defaultErrorHandler.proceed(e)
        }
    }

    private fun doSomeThing(){
        view.get()!!.showAuthenticationError()
    }

    override fun attachView(view: CanShowError) {
        check(view is CanShowAuthenticationError){"View should be CanShowAuthenticationError"}
        this.view = (view as CanShowAuthenticationError).weak()
        defaultErrorHandler.attachView(view)
    }

    override fun dettachView() {
        defaultErrorHandler.dettachView()
    }
}