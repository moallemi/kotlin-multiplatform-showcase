package me.moallemi.kmpshowcase.server.model

import kotlinx.serialization.Serializable

@Serializable
data class Links(
    val appStore: String? = null,
    val googlePlay: String? = null,
    val website: String? = null,
    val article: String? = null,
)