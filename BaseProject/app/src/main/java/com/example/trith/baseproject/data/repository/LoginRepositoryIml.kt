package com.example.trith.baseproject.data.repository

import com.example.trith.baseproject.data.FakeData
import com.example.trith.baseproject.data.model.mapper.UserDataMapper
import com.example.trith.baseproject.domain.entity.User
import com.example.trith.baseproject.domain.repository.LoginRepository
import com.example.trith.baseproject.exception.AuthenticationFailureException
import io.reactivex.Single
import java.util.concurrent.TimeUnit

/**
 * Created by tri.th on 27/08/2018.
 */
class LoginRepositoryIml:LoginRepository {

    override fun login(userName: String, password: String): Single<User> {
        return Single.just(Pair(userName,password))
                .delay(2000,TimeUnit.MILLISECONDS)
                .map {
                    val userModel = FakeData.userList.find { it.name.contentEquals(userName)}
                    if (null != userModel){
                        val mapper = UserDataMapper()
                        return@map mapper.map(userModel)
                    }
                    throw AuthenticationFailureException()
                }
    }

}

