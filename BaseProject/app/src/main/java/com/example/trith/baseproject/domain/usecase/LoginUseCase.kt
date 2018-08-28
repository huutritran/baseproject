package com.example.trith.baseproject.domain.usecase

import com.example.trith.baseproject.domain.AccountValidator
import com.example.trith.baseproject.domain.entity.User
import com.example.trith.baseproject.domain.repository.LoginRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by tri.th on 27/08/2018.
 */
class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) {

    private val accoutValidator = AccountValidator()

    fun execute(userName: String, password: String): Single<User> {
        return Single.just(Pair(userName, password))
                .doOnSuccess { (userName, password) ->
                    if (!accoutValidator.isValid(userName, password)) {
                        throw IllegalArgumentException()
                    }
                }
                .flatMap { loginRepository.login(userName, password) }
    }
}