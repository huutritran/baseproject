package com.example.trith.baseproject.di.module

import com.example.trith.baseproject.presentation.ui.main.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by tri.th on 23/08/2018.
 */
@Module
abstract class MainModule {
    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment
}