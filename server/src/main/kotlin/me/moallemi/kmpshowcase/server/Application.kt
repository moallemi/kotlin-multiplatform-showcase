package me.moallemi.kmpshowcase.server

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.routing.routing
import io.ktor.serialization.json

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@JvmOverloads
fun Application.module(testing: Boolean = false) {
    
    install(ContentNegotiation) {
        json()
    }

    routing {
        home()
        apiV1()
    }
}