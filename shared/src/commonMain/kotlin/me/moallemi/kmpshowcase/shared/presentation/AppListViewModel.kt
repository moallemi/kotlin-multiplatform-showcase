package me.moallemi.kmpshowcase.shared.presentation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.moallemi.kmpshowcase.shared.domain.model.App
import me.moallemi.kmpshowcase.shared.presentation.AppListViewModelNavigation.NavigateToUrl
import me.moallemi.kmpshowcase.shared.repository.AppRepository
import me.moallemi.kmpshowcase.shared.utils.applicationDispatcher

class AppListViewModel(
    private val appRepository: AppRepository
) : BaseViewModel(applicationDispatcher) {

    private val _apps = MutableStateFlow<List<App>>(emptyList())
    val apps: StateFlow<List<App>> = _apps

    private val _navigation =
        MutableStateFlow<AppListViewModelNavigation?>(null)
    val navigation: StateFlow<AppListViewModelNavigation?> = _navigation

    fun load() {
        launch {
            appRepository.getAllAppsAsFlow().collect {
                _apps.value = it
            }
        }
    }

    fun onGooglePlayLinkClicked(url: String?) {
        _navigation.value = NavigateToUrl(url)
    }

    fun onAppStoreLinkClicked(url: String?) {
        _navigation.value = NavigateToUrl(url)
    }

    fun onWebsiteLinkClicked(url: String?) {
        _navigation.value = NavigateToUrl(url)
    }
}