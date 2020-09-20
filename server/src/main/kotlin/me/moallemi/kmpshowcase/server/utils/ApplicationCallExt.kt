package me.moallemi.kmpshowcase.server.utils

import io.ktor.application.ApplicationCall
import io.ktor.features.origin
import io.ktor.request.host
import io.ktor.request.port

fun ApplicationCall.baseUrl() =
    if (request.host() != "0.0.0.0") {
        "https://${request.host()}"
    } else {
        "${request.origin.scheme}://${request.host()}:${request.port()}"
    }
