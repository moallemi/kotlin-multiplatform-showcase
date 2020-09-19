package me.moallemi.kmpshowcase.shared.domain.mapper

import me.moallemi.kmpshowcase.shared.domain.model.Links
import me.moallemi.kmpshowcase.shared.network.response.LinksDto

internal class LinksDtoToLinks : Mapper<LinksDto?, Links?> {

    override fun map(from: LinksDto?) = from?.let { linksDto ->
        Links(
            appStore = linksDto.appStore,
            googlePlay = linksDto.googlePlay,
            website = linksDto.website
        )
    }
}