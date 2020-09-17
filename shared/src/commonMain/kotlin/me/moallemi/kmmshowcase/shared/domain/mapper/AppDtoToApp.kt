package me.moallemi.kmmshowcase.shared.domain.mapper

import me.moallemi.kmmshowcase.shared.domain.model.App
import me.moallemi.kmmshowcase.shared.domain.model.Links
import me.moallemi.kmmshowcase.shared.network.response.AppDto
import me.moallemi.kmmshowcase.shared.network.response.LinksDto

class AppDtoToApp(
    private val linksDtoToLinks: Mapper<LinksDto?, Links?>,
) : Mapper<AppDto, App> {

    override fun map(from: AppDto) = with(from) {
        App(
            name = name,
            description = description,
            links = linksDtoToLinks.map(links)
        )
    }
}