package me.moallemi.kmpshowcase.server.model

import kotlinx.serialization.Serializable

@Serializable
data class AppsResponse(
    val lastUpdate: String,
    val apps: List<App>
)