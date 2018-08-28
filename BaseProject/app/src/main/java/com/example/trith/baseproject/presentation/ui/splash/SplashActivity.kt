package com.example.trith.baseproject.presentation.ui.splash

import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import com.example.trith.baseproject.R
import com.example.trith.baseproject.common.PrefHelper
import com.example.trith.baseproject.common.PrefHelper.get
import com.example.trith.baseproject.presentation.base.BaseActivity
import com.example.trith.baseproject.presentation.ui.login.LoginActivity
import com.example.trith.baseproject.presentation.ui.main.MainActivity
import org.jetbrains.anko.startActivity
import timber.log.Timber
import javax.inject.Inject

class SplashActivity : BaseActivity() {
    @Inject
    lateinit var mSharedPreferences: SharedPreferences
    override fun getLayoutId(): Int = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val isLogged:Boolean = mSharedPreferences.get(PrefHelper.PREF_IS_LOGIN)
        if (isLogged){
            Timber.d("Was logged in, start MainActivity")
            startActivity<MainActivity>()
        }else{
            Timber.d("Not yet log in, start LoginActivity")
            startActivity<LoginActivity>()
        }
        finish()
    }
}
