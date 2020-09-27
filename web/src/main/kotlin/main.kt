import kotlinx.browser.document
import kotlinx.html.dom.append
import me.moallemi.kmpshowcase.shared.di.initKoinJs

fun main() {
    initKoinJs()

    val app = Application()
    app.load { apps ->
        if (apps.isNotEmpty()) {
            document.getElementById("loader")?.remove()
        }
        document.getElementById("root")
            ?.append {
                apps.onEach(::createCard)
            }
    }
}