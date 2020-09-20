package me.moallemi.kmpshowcase.server

import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import me.moallemi.kmpshowcase.server.utils.getResourceContent

fun Route.home() {
    get("/") {
        call.respond(HttpStatusCode.ServiceUnavailable)
    }
}

fun Route.apiV1() {
    route("/api/v1") {
        apps()
    }
}

fun Route.apps() {
    get("/apps") {
        val fileContent = getResourceContent("response/apps.json")
        call.respondText(fileContent, ContentType.Application.Json)
    }
}