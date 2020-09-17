package me.moallemi.kmmshowcase.shared.network.api

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.takeFrom
import io.ktor.utils.io.core.use
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.reflect.KClass

class Ketrofit(
    private val httpClient: HttpClient,
    private val json: Json,
) {

    @Suppress("UNCHECKED_CAST")
    suspend fun <T> get(kClass: KClass<*>, path: String): T {
        val rawResult = httpClient.use {
            httpClient.get<String> {
                url {
                    takeFrom(BASE_URL)
                    encodedPath = path
                }
            }
        }

        return json.decodeFromString(kClass.serializer(), rawResult) as T
    }

    companion object {
        private const val BASE_URL = "https://kmm-showcase.herokuapp.com/"
    }
}