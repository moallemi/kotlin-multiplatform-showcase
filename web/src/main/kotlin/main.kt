import kotlinx.browser.document
import me.moallemi.kmpshowcase.shared.di.initKoinJs
import react.dom.render
import react.child

fun main() {
    initKoinJs()

    val app = Application()
    render(document.getElementById("root")) {
        child(app.createRootComponent())
    }
}