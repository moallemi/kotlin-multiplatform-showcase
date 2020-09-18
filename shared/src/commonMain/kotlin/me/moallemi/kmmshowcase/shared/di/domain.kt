package me.moallemi.kmmshowcase.shared.di

import me.moallemi.kmmshowcase.shared.domain.mapper.AppDtoToApp
import me.moallemi.kmmshowcase.shared.domain.mapper.LinksDtoToLinks
import me.moallemi.kmmshowcase.shared.domain.mapper.Mapper
import me.moallemi.kmmshowcase.shared.domain.model.App
import me.moallemi.kmmshowcase.shared.domain.model.Links
import me.moallemi.kmmshowcase.shared.network.response.AppDto
import me.moallemi.kmmshowcase.shared.network.response.LinksDto
import me.moallemi.kmmshowcase.shared.repository.AppRepository
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val domainModule = module {
    single<Mapper<LinksDto?, Links?>>(named("a")) {
        LinksDtoToLinks()
    }
    single<Mapper<AppDto, App>>(named("b")) {
        AppDtoToApp(get(named("a")))
    }
    single { AppRepository(get(), get(named("b"))) }
}