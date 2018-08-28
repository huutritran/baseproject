package com.example.trith.baseproject.data.local.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.trith.baseproject.data.model.UserModel
import io.reactivex.Flowable

/**
 * Created by tri.th on 28/08/2018.
 */
@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: UserModel)

    @Query("SELECT * FROM usermodel WHERE name =:userName")
    fun findByName(userName: String): Flowable<List<UserModel>>
}