package com.example.trith.baseproject.presentation.base

import android.arch.lifecycle.ViewModel
import com.example.trith.baseproject.common.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 * Created by tri.th on 24/08/2018.
 */
open class BaseViewModel : ViewModel() {
    @Inject
    lateinit var scheduleProvider:SchedulerProvider
    protected val isLoading = PublishSubject.create<Boolean>()
    protected val compositeDisposable = CompositeDisposable()

    fun getIsLoading():PublishSubject<Boolean> = isLoading

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}