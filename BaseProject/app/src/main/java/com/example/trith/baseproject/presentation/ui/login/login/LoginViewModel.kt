package com.example.trith.baseproject.presentation.ui.login.login

import com.example.trith.baseproject.domain.entity.User
import com.example.trith.baseproject.domain.usecase.LoginUseCase
import com.example.trith.baseproject.presentation.base.BaseViewModel
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

/**
 * Created by tri.th on 27/08/2018.
 */

class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : BaseViewModel() {

    fun doLogin(userName: String, password: String, disposableSingleObserver: DisposableSingleObserver<User>) {
        loginUseCase.execute(userName, password)
                .subscribeOn(scheduleProvider.io())
                .observeOn(scheduleProvider.ui())
                .doOnSubscribe { isLoading.onNext(true) }
                .doOnSuccess { isLoading.onNext(false) }
                .doOnError{isLoading.onNext(false)}
                .subscribeWith(disposableSingleObserver)
                .let { compositeDisposable.add(it) }
    }

}