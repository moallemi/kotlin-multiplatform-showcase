package me.moallemi.kmpshowcase.shared.di

import me.moallemi.kmpshowcase.shared.domain.mapper.AppDtoToApp
import me.moallemi.kmpshowcase.shared.domain.mapper.LinksDtoToLinks
import me.moallemi.kmpshowcase.shared.domain.mapper.Mapper
import me.moallemi.kmpshowcase.shared.domain.model.App
import me.moallemi.kmpshowcase.shared.domain.model.Links
import me.moallemi.kmpshowcase.shared.network.response.AppDto
import me.moallemi.kmpshowcase.shared.network.response.LinksDto
import me.moallemi.kmpshowcase.shared.repository.AppRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val domainModule = module {
    single<Mapper<LinksDto?, Links?>>(
        named(QUALIFIER_NAME_MAPPER_LINKSDTO_TOLINKS)
    ) {
        LinksDtoToLinks()
    }
    single<Mapper<AppDto, App>>(
        named(QUALIFIER_NAME_MAPPER_APPDTO_TO_APP)
    ) {
        AppDtoToApp(
            get(named(QUALIFIER_NAME_MAPPER_LINKSDTO_TOLINKS))
        )
    }
    single {
        AppRepository(
            get(),
            get(named(QUALIFIER_NAME_MAPPER_APPDTO_TO_APP))
        )
    }
}