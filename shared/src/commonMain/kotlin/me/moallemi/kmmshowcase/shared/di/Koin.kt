package me.moallemi.kmmshowcase.shared.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(
        networkModule,
        domainModule,
        platformModule
    )
}

fun initKoin() = initKoin {}

expect val platformModule: Module