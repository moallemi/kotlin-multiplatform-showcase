package me.moallemi.kmmshowcase.androidApp.di

import me.moallemi.kmmshowcase.shared.presentation.AppListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { AppListViewModel(get()) }
}