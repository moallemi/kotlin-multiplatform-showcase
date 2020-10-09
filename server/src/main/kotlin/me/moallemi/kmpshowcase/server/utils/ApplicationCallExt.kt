package me.moallemi.kmpshowcase.server.utils

import io.ktor.application.ApplicationCall
import io.ktor.features.origin
import io.ktor.request.host
import io.ktor.request.port

fun ApplicationCall.baseUrl() =
    if (request.host() !in listOf("0.0.0.0", "localhost", "10.0.2.2")) {
        "https://${request.host()}"
    } else {
        "${request.origin.scheme}://${request.host()}:${request.port()}"
    }
