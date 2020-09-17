package me.moallemi.kmmshowcase.shared.network.api

import me.moallemi.kmmshowcase.shared.network.response.AppsResponseDto

class KmmShowcaseApiImpl(
    private val ketrofit: Ketrofit
) : KmmShowcaseApi {

    override suspend fun getApps(): AppsResponseDto =
        ketrofit.get(AppsResponseDto::class, "api/v1/apps")
}