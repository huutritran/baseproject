package com.example.trith.baseproject.common

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import java.lang.ref.WeakReference

@SuppressLint("MissingPermission")
fun Context.isNetworkConnected(): Boolean {
    val connectManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    if (null != connectManager) {
        val netInfo = connectManager.activeNetworkInfo
        return (netInfo != null) && netInfo.isConnectedOrConnecting
    }
    return false
}
fun <T>T.weak() =WeakReference(this)