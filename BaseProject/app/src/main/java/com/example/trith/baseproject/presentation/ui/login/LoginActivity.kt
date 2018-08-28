package com.example.trith.baseproject.presentation.ui.login

import android.os.Bundle
import com.example.trith.baseproject.R
import com.example.trith.baseproject.presentation.base.BaseActivity
import javax.inject.Inject

class LoginActivity : BaseActivity() {
    @Inject
    lateinit var loginNavigation: LoginNavigation
    override fun getLayoutId(): Int = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginNavigation.showLogin()
    }
}
