package com.example.trith.baseproject.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.SharedPreferences
import com.example.trith.baseproject.common.PrefHelper
import com.example.trith.baseproject.common.ResourceManager
import com.example.trith.baseproject.common.rx.AppScheduleProvider
import com.example.trith.baseproject.common.rx.SchedulerProvider
import com.example.trith.baseproject.data.local.AppDatabase
import com.example.trith.baseproject.data.remote.BaseService
import com.example.trith.baseproject.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by tri.th on 23/08/2018.
 */
@Module(includes = [ViewModelModule::class, RepositoryModule::class, DaoModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideDb(application: Application): AppDatabase = Room.databaseBuilder(application, AppDatabase::class.java, "AppDatabase.db")
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideSharedPreference(application: Application): SharedPreferences = PrefHelper.defaultPrefs(application)


    @Singleton
    @Provides
    fun provideResourceManager(application: Application): ResourceManager = ResourceManager(application)

    @Singleton
    @Provides
    fun provideOkHttpClient(cache: Cache): OkHttpClient = OkHttpClient.Builder()
            .cache(cache)
            .build()


    @Singleton
    @Provides
    fun provideRestAdapter(client: OkHttpClient): Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BaseService.BASE_URL)
            .client(client)
            .build()

    @Singleton
    @Provides
    fun provideBaseService(retrofit: Retrofit): BaseService = retrofit.create(BaseService::class.java)

    @Singleton
    @Provides
    fun provideHttpCache(application: Application): Cache {
        val cacheSize = 10L * 1024 * 1024 // 10MB of network cache
        return Cache(application.cacheDir, cacheSize)
    }

    @Singleton
    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = AppScheduleProvider()

}