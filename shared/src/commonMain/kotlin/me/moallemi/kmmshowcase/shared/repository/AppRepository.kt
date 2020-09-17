package me.moallemi.kmmshowcase.shared.repository

import me.moallemi.kmmshowcase.shared.domain.mapper.Mapper
import me.moallemi.kmmshowcase.shared.domain.model.App
import me.moallemi.kmmshowcase.shared.network.api.KmpShowcaseApi
import me.moallemi.kmmshowcase.shared.network.response.AppDto

class AppRepository(
    private val kmpShowcaseApi: KmpShowcaseApi,
    private val appDtoToApp: Mapper<AppDto, App>,
) {
    suspend fun getAllApps(): List<App> =
        kmpShowcaseApi.getApps().apps.map(appDtoToApp::map)
}