package me.moallemi.kmpshowcase.shared.di

import me.moallemi.kmpshowcase.shared.domain.mapper.AppDtoToApp
import me.moallemi.kmpshowcase.shared.domain.mapper.LinksDtoToLinks
import me.moallemi.kmpshowcase.shared.repository.AppRepository
import org.koin.dsl.module

internal val domainModule = module {
    single {
        LinksDtoToLinks()
    }
    single {
        AppDtoToApp(get())
    }
    single {
        AppRepository(get(), get())
    }
}