package me.moallemi.kmmshowcase.shared.network.api

import me.moallemi.kmmshowcase.shared.network.response.AppsResponseDto

interface KmmShowcaseApi {
    suspend fun getApps(): AppsResponseDto
}