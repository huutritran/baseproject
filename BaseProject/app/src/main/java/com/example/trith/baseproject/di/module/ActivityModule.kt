package com.example.trith.baseproject.di.module

import com.example.trith.baseproject.di.scope.LoginActivityScope
import com.example.trith.baseproject.presentation.ui.login.LoginActivity
import com.example.trith.baseproject.presentation.ui.main.MainActivity
import com.example.trith.baseproject.presentation.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by tri.th on 23/08/2018.
 */
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

    @LoginActivityScope
    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun contributeLoginActivity(): LoginActivity
}