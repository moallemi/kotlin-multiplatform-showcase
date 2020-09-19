package me.moallemi.kmpshowcase.shared.di

import me.moallemi.kmpshowcase.shared.presentation.AppListViewModel
import org.koin.dsl.module

internal val viewModelsModule = module {
    factory { AppListViewModel(get()) }
}