package me.moallemi.kmpshowcase.shared.domain.mapper

import me.moallemi.kmpshowcase.shared.domain.model.App
import me.moallemi.kmpshowcase.shared.network.response.AppDto

class AppDtoToApp(
    private val linksDtoToLinks: LinksDtoToLinks,
) {

    fun map(from: AppDto) = with(from) {
        App(
            id = name,
            name = name,
            summary = summary,
            links = linksDtoToLinks.map(links),
            bannerUrl = bannerUrl
        )
    }
}