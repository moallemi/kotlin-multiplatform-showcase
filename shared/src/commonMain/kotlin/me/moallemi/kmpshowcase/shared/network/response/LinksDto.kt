package me.moallemi.kmpshowcase.shared.network.response

import kotlinx.serialization.Serializable

@Serializable
data class LinksDto(
    val appStore: String?,
    val googlePlay: String?,
    val website: String?
)