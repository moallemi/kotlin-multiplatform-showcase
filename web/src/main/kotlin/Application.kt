import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.html.TagConsumer
import kotlinx.html.h5
import kotlinx.html.js.a
import kotlinx.html.js.div
import kotlinx.html.js.img
import kotlinx.html.js.p
import me.moallemi.kmpshowcase.shared.domain.model.App
import me.moallemi.kmpshowcase.shared.domain.model.Links
import me.moallemi.kmpshowcase.shared.presentation.AppListViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.w3c.dom.HTMLElement

class Application : KoinComponent {

    private val appListViewModel: AppListViewModel by inject()

    fun load(result: (List<App>) -> Unit) {
        GlobalScope.launch {
            appListViewModel.apps.collect {
                result(it)
            }
        }
        appListViewModel.load()
    }
}

fun TagConsumer<HTMLElement>.createCard(app: App) {
    div(classes = "card kmp-card") {
        img(src = app.bannerUrl, classes = "card-img-top")
        div(classes = "card-body") {
            h5(classes = "card-title") { +app.name }
            p(classes = "card-text") { +app.summary }
            div {
                createCardLinks(app.links)
            }
        }
    }
}

fun TagConsumer<HTMLElement>.createCardLinks(links: Links?) = links?.let {
    links.website?.let { link ->
        a(href = link, target = "_blank", classes = "btn btn-primary") { +"Website" }
    }
    links.googlePlay?.let { link ->
        a(href = link, target = "_blank", classes = "btn btn-primary") { +"Google Play" }
    }
    links.appStore?.let { link ->
        a(href = link, target = "_blank", classes = "btn btn-primary") { +"App Store" }
    }
}