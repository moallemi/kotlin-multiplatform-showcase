package me.moallemi.kmpshowcase.shared.di

import me.moallemi.kmpshowcase.shared.presentation.AppListViewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(
        networkModule,
        domainModule,
        platformModule
    )
}

fun initKoin() = initKoin {
    modules(
        module {
            factory { AppListViewModel(get()) }
        }
    )
}

expect val platformModule: Module