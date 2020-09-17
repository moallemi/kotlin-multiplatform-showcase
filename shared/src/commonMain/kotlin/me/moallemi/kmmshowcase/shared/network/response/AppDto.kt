package me.moallemi.kmmshowcase.shared.network.response

import kotlinx.serialization.Serializable

@Serializable
data class AppDto(
    val name: String,
    val description: String,
    val links: LinksDto?
)