package me.moallemi.kmmshowcase.shared.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.moallemi.kmmshowcase.shared.domain.mapper.Mapper
import me.moallemi.kmmshowcase.shared.domain.model.App
import me.moallemi.kmmshowcase.shared.network.api.KmpShowcaseApi
import me.moallemi.kmmshowcase.shared.network.response.AppDto

class AppRepository(
    private val kmpShowcaseApi: KmpShowcaseApi,
    private val appDtoToApp: Mapper<AppDto, App>,
) {
    fun getAllAppsAsFlow(): Flow<List<App>> = flow {
        kmpShowcaseApi.getApps()
            .apps
            .map(appDtoToApp::map)
            .let {
                emit(it)
            }
    }

}