import kotlinx.browser.document
import kotlinx.html.dom.append
import me.moallemi.kmpshowcase.shared.di.initKoinJs

fun main() {
    initKoinJs()

    val app = Application()
    app.load { apps ->
        document.getElementById("root")
            ?.append {
                apps.onEach(::createCard)
            }
    }
}