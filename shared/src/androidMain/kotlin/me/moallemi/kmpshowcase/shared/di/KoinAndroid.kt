package me.moallemi.kmpshowcase.shared.di

import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoinAndroid(appDeclaration: KoinAppDeclaration) = initKoin {
    appDeclaration()
}

actual val platformModule: Module = module {
    single {
        OkHttp.create()
    }
}