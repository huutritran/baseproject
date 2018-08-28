package com.example.trith.baseproject.common

import android.os.Build

/**
 * Created by tri.th on 24/08/2018.
 */

inline fun supportsKitKat(code: () -> Unit) {
    supportsVersion(code, 19)
}

inline fun supportsLollipop(code: () -> Unit) {
    if (Build.VERSION.SDK_INT >= 21) {
        code.invoke()
    }
}

inline fun supportsVersion(code: () -> Unit, sdk: Int) {
    if (Build.VERSION.SDK_INT >= sdk) {
        code.invoke()
    }
}