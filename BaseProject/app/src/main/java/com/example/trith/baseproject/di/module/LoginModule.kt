package com.example.trith.baseproject.di.module

import com.example.trith.baseproject.di.scope.LoginActivityScope
import com.example.trith.baseproject.presentation.ui.login.LoginActivity
import com.example.trith.baseproject.presentation.ui.login.login.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by tri.th on 28/08/2018.
 */
@Module
abstract class LoginModule {

    @ContributesAndroidInjector
    abstract fun contributeLoginFragment(): LoginFragment
}