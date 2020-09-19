package me.moallemi.kmpshowcase.shared.domain.mapper

import me.moallemi.kmpshowcase.shared.domain.model.App
import me.moallemi.kmpshowcase.shared.domain.model.Links
import me.moallemi.kmpshowcase.shared.network.response.AppDto
import me.moallemi.kmpshowcase.shared.network.response.LinksDto

internal class AppDtoToApp(
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