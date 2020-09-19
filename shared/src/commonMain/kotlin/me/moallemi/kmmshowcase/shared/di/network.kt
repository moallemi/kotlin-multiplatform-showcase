package me.moallemi.kmmshowcase.shared.di

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import kotlinx.serialization.json.Json
import me.moallemi.kmmshowcase.shared.network.api.KmpShowcaseApi
import org.koin.core.context.loadKoinModules
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

internal val networkModule = module {
    single {
        HttpClient {
            install(JsonFeature) {
                serializer = KotlinxSerializer(this@single.get())
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        // TODO
                    }
                }

                level = LogLevel.INFO
            }
        }
    }
    single {
        Json {
            isLenient = true
            ignoreUnknownKeys = true
        }
    }
    single {
        KmpShowcaseApi(get())
    }
}