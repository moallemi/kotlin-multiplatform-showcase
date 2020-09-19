package me.moallemi.kmmshowcase.shared.presentation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import me.moallemi.kmmshowcase.shared.domain.model.App
import me.moallemi.kmmshowcase.shared.repository.AppRepository
import me.moallemi.kmmshowcase.shared.utils.applicationDispatcher

class AppListViewModel(
    private val appRepository: AppRepository
) : BaseViewModel(applicationDispatcher) {

    val apps = MutableStateFlow<List<App>>(emptyList())

    fun load() {
        launch {
            appRepository.getAllAppsAsFlow().collect {
                apps.value = it
            }
        }
    }
}