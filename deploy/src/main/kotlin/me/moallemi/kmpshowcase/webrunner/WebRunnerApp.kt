package me.moallemi.kmpshowcase.webrunner

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.response.respond
import io.ktor.response.respondRedirect
import io.ktor.routing.get
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@JvmOverloads
fun Application.module(testing: Boolean = false) {

    routing {
        get("/") {
            call.respondRedirect("index.html")
        }
        static("/") {
            resources("")
        }
    }
}