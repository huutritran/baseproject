package com.example.trith.baseproject.errorhandler

import com.example.trith.baseproject.R
import com.example.trith.baseproject.common.ResourceManager
import com.example.trith.baseproject.common.weak
import retrofit2.HttpException
import java.lang.ref.WeakReference
import javax.inject.Inject

/**
 * Created by tri.th on 28/08/2018.
 */
open class DefaultErrorHandler @Inject constructor(private val resourceManager: ResourceManager)
    : ErrorHandler {

    private lateinit var view: WeakReference<CanShowError>
    override fun proceed(e: Throwable) {
        check(view.get() != null) { "View must be attached to ErrorHandler" }
        val message = when (e) {
            is HttpException -> when (e.code()) {
                401 -> resourceManager.getString(R.string.error_unauthorized)
                500 -> resourceManager.getString(R.string.error_internal_server_error)
                else -> resourceManager.getString(R.string.error_unknown_error)
            }
            else -> resourceManager.getString(R.string.error_unknown_error)
        }
        view.get()?.showError(message)
    }

    override fun attachView(view: CanShowError) {
        this.view = view.weak()
    }

    override fun dettachView() {
        this.view.clear()
    }

}