package me.moallemi.kmpshowcase.shared.utils

import me.moallemi.kmpshowcase.shared.utils.LogLevel.DEBUG
import me.moallemi.kmpshowcase.shared.utils.LogLevel.ERROR
import me.moallemi.kmpshowcase.shared.utils.LogLevel.WARN

actual fun log(
    message: String?,
    tag: String,
    level: LogLevel
) {
    when (level) {
        DEBUG -> console.log(message)
        WARN -> console.warn(message)
        ERROR -> console.error(message)
    }.exhaustive
}