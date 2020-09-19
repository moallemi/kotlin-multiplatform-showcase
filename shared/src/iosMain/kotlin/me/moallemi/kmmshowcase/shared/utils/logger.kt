package me.moallemi.kmmshowcase.shared.utils

import platform.Foundation.NSLog

actual fun log(message: String?, tag: String, level: LogLevel) {
    if (message == null) {
        return
    }
    NSLog("$tag: $message")
}