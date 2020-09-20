package me.moallemi.kmpshowcase.server.model

import kotlinx.serialization.Serializable

@Serializable
data class App(
    val id: String,
    val name: String,
    val summary: String,
    val links: Links?,
    var bannerUrl: String? = null
)