package me.moallemi.kmpshowcase.shared.network.api

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import me.moallemi.kmpshowcase.shared.network.response.AppsResponseDto

expect val API_BASE_URL: String

class KmpShowcaseApi(
    private val httpClient: HttpClient,
) {
    suspend fun getApps(): AppsResponseDto = httpClient.get("$API_BASE_URL/api/v1/apps")
}