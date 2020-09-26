package me.moallemi.kmpshowcase.server

import io.ktor.application.Application

private val Application.envType
    get() = environment.config.property("ktor.environment").getString()

val Application.isDev get() = envType == "dev"
val Application.isProd get() = envType == "prod"

val Application.corsAllowedHosts
    get() = environment.config.property("ktor.corsAllowedHosts").getString().split(",")