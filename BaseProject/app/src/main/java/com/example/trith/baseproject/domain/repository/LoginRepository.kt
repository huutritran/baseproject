package com.example.trith.baseproject.domain.repository

import com.example.trith.baseproject.domain.entity.User
import io.reactivex.Single

/**
 * Created by tri.th on 27/08/2018.
 */
interface LoginRepository {
    fun login(userName:String,password:String):Single<User>
}