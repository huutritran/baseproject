package com.example.trith.baseproject.domain.usecase

import com.example.trith.baseproject.domain.entity.User
import com.example.trith.baseproject.domain.repository.UserRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by tri.th on 27/08/2018.
 */

class GetUserDetailUseCase @Inject constructor(private val userRepository: UserRepository) {

    fun getUserDetail(id: Int): Single<User> {
        return userRepository.getUserDetail(id)
    }
}