package me.moallemi.kmpshowcase.shared.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.moallemi.kmpshowcase.shared.domain.mapper.Mapper
import me.moallemi.kmpshowcase.shared.domain.model.App
import me.moallemi.kmpshowcase.shared.network.api.KmpShowcaseApi
import me.moallemi.kmpshowcase.shared.network.response.AppDto

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