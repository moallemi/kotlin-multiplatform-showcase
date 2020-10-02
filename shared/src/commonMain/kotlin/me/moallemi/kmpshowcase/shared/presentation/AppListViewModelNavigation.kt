package me.moallemi.kmpshowcase.shared.presentation

sealed class AppListViewModelNavigation {
    class NavigateToUrl(val url: String?) : AppListViewModelNavigation()
}