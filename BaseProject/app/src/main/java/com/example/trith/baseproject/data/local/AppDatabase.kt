package com.example.trith.baseproject.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.trith.baseproject.data.local.dao.UserDao
import com.example.trith.baseproject.data.model.UserModel

/**
 * Created by tri.th on 28/08/2018.
 */
@Database(entities = [UserModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao():UserDao
}