package com.example.trith.baseproject.domain.repository

import com.example.trith.baseproject.domain.entity.User
import io.reactivex.Single

/**
 * Created by tri.th on 27/08/2018.
 */
interface UserRepository {
    fun getUserList():Single<List<User>>
    fun getUserDetail(userId:Int):Single<User>
}