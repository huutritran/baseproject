package com.example.trith.baseproject.common.rx

import io.reactivex.Scheduler

/**
 * Created by tri.th on 27/08/2018.
 */
interface SchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler

}