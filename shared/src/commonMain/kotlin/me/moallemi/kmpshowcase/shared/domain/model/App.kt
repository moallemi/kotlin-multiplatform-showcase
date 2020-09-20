package me.moallemi.kmpshowcase.shared.domain.model

data class App(
    override val id: String,
    val name: String,
    val summary: String,
    val links: Links?,
    val bannerUrl: String?
) : Identifiable