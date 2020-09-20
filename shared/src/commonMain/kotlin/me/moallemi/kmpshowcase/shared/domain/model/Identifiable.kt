package me.moallemi.kmpshowcase.shared.domain.model

interface Identifiable {
    val id: String
    override fun equals(other: Any?): Boolean
}