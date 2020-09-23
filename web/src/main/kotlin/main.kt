import kotlinx.browser.document
import me.moallemi.kmpshowcase.shared.di.initKoinJs

fun main() {
    initKoinJs()

    val app = Application()
    app.load {
        document.body?.textContent = it
    }
}