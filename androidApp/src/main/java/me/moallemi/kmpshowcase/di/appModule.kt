package me.moallemi.kmpshowcase.di

import me.moallemi.kmpshowcase.shared.presentation.AppListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { AppListViewModel(get()) }
}