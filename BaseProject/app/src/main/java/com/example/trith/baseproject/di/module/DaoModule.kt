package com.example.trith.baseproject.di.module

import com.example.trith.baseproject.data.local.AppDatabase
import com.example.trith.baseproject.data.local.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by tri.th on 28/08/2018.
 */
@Module
class DaoModule{
    @Singleton
    @Provides
    fun provideUserDao(db:AppDatabase):UserDao = db.userDao()

}