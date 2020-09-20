package me.moallemi.kmpshowcase.shared.domain.model

data class App(
    override val id: String,
    val name: String,
    val description: String,
    val links: Links?
) : Identifiable