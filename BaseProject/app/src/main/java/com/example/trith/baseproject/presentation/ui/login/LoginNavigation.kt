package com.example.trith.baseproject.presentation.ui.login

import android.annotation.SuppressLint
import com.example.trith.baseproject.R
import com.example.trith.baseproject.di.scope.LoginActivityScope
import com.example.trith.baseproject.presentation.ui.login.login.LoginFragment
import com.example.trith.baseproject.presentation.ui.main.MainActivity
import org.jetbrains.anko.startActivity
import timber.log.Timber
import java.lang.ref.WeakReference
import javax.inject.Inject

/**
 * Created by tri.th on 27/08/2018.
 */
@LoginActivityScope
class LoginNavigation @Inject constructor(loginActivity: LoginActivity) {
    companion object {
        var instance:Int = 0
    }
    init {
        instance+=1
        Timber.d("Instance count: $instance")
    }
    val activity = WeakReference<LoginActivity>(loginActivity)
    val containerId = R.id.loginFrameLayout
    val fragmentManager = activity.get()?.supportFragmentManager

    @SuppressLint("CommitTransaction")
    fun showLogin() {
        val fragment = LoginFragment()
        fragmentManager?.beginTransaction()?.apply {
            replace(containerId, fragment, "LoginFragment")
            addToBackStack("LoginFragment")
            commit()
        }
    }

    fun navigateToMain() {
        activity.get()?.startActivity<MainActivity>()
    }
}