package me.moallemi.kmmshowcase.shared.di

import co.touchlab.kermit.Kermit
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import kotlinx.serialization.json.Json
import me.moallemi.kmmshowcase.shared.network.api.KmpShowcaseApi
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.core.scope.Scope
import org.koin.dsl.module

fun initKoin(appModule: Module): KoinApplication {
    val koinApplication = startKoin {
        modules(
            appModule,
            platformModule,
            coreModule
        )
    }
    return koinApplication
}

private val coreModule = module {
    single {
        HttpClient {
            install(JsonFeature) {
                serializer = KotlinxSerializer(this@single.get())
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        this@single.get<Kermit> {
                            parametersOf("ktor")
                        }.i { message }
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

internal inline fun <reified T> Scope.getWith(vararg params: Any?): T {
    return get(parameters = { parametersOf(*params) })
}

expect val platformModule: Module
