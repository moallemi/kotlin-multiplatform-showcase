package me.moallemi.kmpshowcase.shared.network.response

import kotlinx.serialization.Serializable

@Serializable
data class AppDto(
    val name: String,
    val summary: String,
    val links: LinksDto?,
    val bannerUrl: String?
)