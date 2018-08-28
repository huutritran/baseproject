package com.example.trith.baseproject.data.repository

import com.example.trith.baseproject.domain.entity.User
import com.example.trith.baseproject.domain.repository.UserRepository
import io.reactivex.Single

/**
 * Created by tri.th on 27/08/2018.
 */
class UserRepositoryIml:UserRepository {
    override fun getUserList(): Single<List<User>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUserDetail(userId: Int): Single<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}