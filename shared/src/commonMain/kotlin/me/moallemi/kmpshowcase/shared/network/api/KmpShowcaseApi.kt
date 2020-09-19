package me.moallemi.kmpshowcase.shared.network.api

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import me.moallemi.kmpshowcase.shared.network.response.AppsResponseDto

class KmpShowcaseApi(
    private val httpClient: HttpClient,
) {
    private val baseUrl = "https://kmm-showcase.herokuapp.com"

    suspend fun getApps(): AppsResponseDto = httpClient.get("$baseUrl/api/v1/apps")
}