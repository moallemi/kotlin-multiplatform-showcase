package me.moallemi.kmmshowcase.shared.domain.mapper

import me.moallemi.kmmshowcase.shared.domain.model.Links
import me.moallemi.kmmshowcase.shared.network.response.LinksDto

class LinksDtoToLinks : Mapper<LinksDto?, Links?> {

    override fun map(from: LinksDto?) = from?.let { linksDto ->
        Links(
            appStore = linksDto.appStore,
            googlePlay = linksDto.googlePlay,
            website = linksDto.website
        )
    }
}