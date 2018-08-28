package com.example.trith.baseproject.di

import android.app.Application
import com.example.trith.baseproject.App
import com.example.trith.baseproject.di.module.ActivityModule
import com.example.trith.baseproject.di.module.AppModule
import com.example.trith.baseproject.di.module.LoginModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by tri.th on 23/08/2018.
 */

@Singleton
@Component(
        modules = [
            AppModule::class,
            ActivityModule::class,
            AndroidSupportInjectionModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}