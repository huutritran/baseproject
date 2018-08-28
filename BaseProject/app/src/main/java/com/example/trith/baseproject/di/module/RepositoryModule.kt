package com.example.trith.baseproject.di.module

import com.example.trith.baseproject.data.repository.LoginRepositoryIml
import com.example.trith.baseproject.data.repository.UserRepositoryIml
import com.example.trith.baseproject.domain.repository.LoginRepository
import com.example.trith.baseproject.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by tri.th on 27/08/2018.
 */
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideLoginRepository():LoginRepository = LoginRepositoryIml()
}