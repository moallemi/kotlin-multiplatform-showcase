package me.moallemi.kmmshowcase.shared.di

import me.moallemi.kmmshowcase.shared.presentation.AppListViewModel
import org.koin.dsl.module

internal val viewModelsModule = module {
    factory { AppListViewModel(get()) }
}