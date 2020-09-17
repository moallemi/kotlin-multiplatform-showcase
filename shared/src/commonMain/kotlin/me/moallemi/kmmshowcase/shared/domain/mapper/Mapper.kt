package me.moallemi.kmmshowcase.shared.domain.mapper

interface Mapper<in F, out T> {
    fun map(from: F): T
}