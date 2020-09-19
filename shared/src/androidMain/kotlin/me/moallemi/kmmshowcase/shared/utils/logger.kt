package me.moallemi.kmmshowcase.shared.utils

import android.util.Log

actual fun log(message: String?, tag: String, level: LogLevel) {
    if (message == null) {
        return
    }

    when (level) {
        LogLevel.DEBUG -> Log.d(tag, message)
        LogLevel.WARN -> Log.w(tag, message)
        LogLevel.ERROR -> Log.e(tag, message)
    }.exhaustive
}