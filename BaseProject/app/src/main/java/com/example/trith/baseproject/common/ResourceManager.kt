package com.example.trith.baseproject.common

import android.content.Context
import android.support.annotation.StringRes

/**
 * Created by tri.th on 28/08/2018.
 */
class ResourceManager constructor(private val context: Context) {

    fun getString(@StringRes resId: Int): String {
        return context.resources.getString(resId)
    }
}