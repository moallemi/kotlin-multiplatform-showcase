package me.moallemi.kmpshowcase.shared.di

import io.ktor.client.engine.js.Js
import org.koin.core.module.Module
import org.koin.dsl.module

fun initKoinJs() = initKoin {
    modules(
        viewModelsModule
    )
}

actual val platformModule: Module = module {
    single {
        Js.create()
    }
}