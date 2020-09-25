import kotlinx.css.CSSBuilder
import kotlinx.css.body
import kotlinx.css.margin
import kotlinx.css.padding
import kotlinx.css.px

object Styles {

    val global: CSSBuilder.() -> Unit = {
        body {
            margin(0.px)
            padding(0.px)
        }
    }

}
