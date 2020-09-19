package me.moallemi.kmpshowcase.shared.network.response

import kotlinx.serialization.Serializable

@Serializable
data class AppDto(
    val name: String,
    val description: String,
    val links: LinksDto?
)