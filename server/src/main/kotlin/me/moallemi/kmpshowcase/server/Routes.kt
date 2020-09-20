package me.moallemi.kmpshowcase.server

import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import me.moallemi.kmpshowcase.server.model.AppsResponse
import me.moallemi.kmpshowcase.server.utils.baseUrl
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
        val appsResponse = Json.decodeFromString<AppsResponse>(fileContent)
        appsResponse.apps.onEach { app ->
            app.bannerUrl = "${call.baseUrl()}/images/apps/${app.id}.png"
        }
        call.respond(appsResponse)
    }
}