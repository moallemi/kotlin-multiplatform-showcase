package me.moallemi.kmpshowcase.shared.network.response

import kotlinx.serialization.Serializable

@Serializable
data class AppsResponseDto(
    val lastUpdate: String,
    val apps: List<AppDto>
)