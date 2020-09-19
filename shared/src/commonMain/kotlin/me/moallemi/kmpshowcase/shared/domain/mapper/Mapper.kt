package me.moallemi.kmpshowcase.shared.domain.mapper

interface Mapper<in F, out T> {
    fun map(from: F): T
}