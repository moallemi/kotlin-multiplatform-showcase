package me.moallemi.kmpshowcase.shared.domain.mapper

// FIXME due to inconsistency we can not use generic interfaces with Koin
// https://github.com/InsertKoinIO/koin/issues/75#issuecomment-474405908
interface Mapper<in F, out T> {
    fun map(from: F): T
}