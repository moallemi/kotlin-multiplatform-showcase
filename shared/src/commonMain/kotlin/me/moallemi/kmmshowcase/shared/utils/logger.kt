package me.moallemi.kmmshowcase.shared.utils

enum class LogLevel {
    DEBUG, WARN, ERROR
}

expect fun log(message: String?, tag: String = "KmpShowcase", level: LogLevel = LogLevel.DEBUG)