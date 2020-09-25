import kotlinx.css.Align
import kotlinx.css.CSSBuilder
import kotlinx.css.Color
import kotlinx.css.Display
import kotlinx.css.FlexDirection
import kotlinx.css.FlexWrap
import kotlinx.css.JustifyContent
import kotlinx.css.ObjectFit
import kotlinx.css.alignSelf
import kotlinx.css.backgroundColor
import kotlinx.css.body
import kotlinx.css.borderRadius
import kotlinx.css.borderTopLeftRadius
import kotlinx.css.borderTopRightRadius
import kotlinx.css.color
import kotlinx.css.display
import kotlinx.css.flexDirection
import kotlinx.css.flexWrap
import kotlinx.css.fontFamily
import kotlinx.css.fontSize
import kotlinx.css.height
import kotlinx.css.justifyContent
import kotlinx.css.lineHeight
import kotlinx.css.margin
import kotlinx.css.objectFit
import kotlinx.css.padding
import kotlinx.css.pct
import kotlinx.css.properties.boxShadow
import kotlinx.css.properties.lh
import kotlinx.css.px
import kotlinx.css.width

object Styles {

    val global: CSSBuilder.() -> Unit = {
        body {
            margin(0.px)
            padding(0.px)
        }
    }

    val banner: CSSBuilder.() -> Unit = {
        width = 100.pct
        height = 120.px
        padding(vertical = 30.px)
        backgroundColor = Color("#4c49eb")
    }

    val appList: CSSBuilder.() -> Unit = {
        display = Display.flex
        flexWrap = FlexWrap.wrap
        justifyContent = JustifyContent.center
    }

    object Card {

        val root: CSSBuilder.() -> Unit = {
            width = 200.px
            borderRadius = 5.px
            margin(vertical = 16.px, horizontal = 16.px)
            boxShadow(
                Color("#0000000d"),
                0.px,
                4.px,
                8.px,
                0.px,
            )
        }

        val header: CSSBuilder.() -> Unit = {
            display = Display.flex
            flexDirection = FlexDirection.column
            width = 100.pct
            height = 100.px
            borderTopLeftRadius = 5.px
            borderTopRightRadius = 5.px
            backgroundColor = Color("#eaeaea")
        }

        val headerImage: CSSBuilder.() -> Unit = {
            alignSelf = Align.center
            width = 80.pct
            height = 100.pct
            objectFit = ObjectFit.scaleDown
        }

        val content: CSSBuilder.() -> Unit = {
            padding(vertical = 2.px, horizontal = 16.px)
        }

        val contentTitle: CSSBuilder.() -> Unit = {
            fontFamily = "sans-serif"
            fontSize = 16.px
            color = Color("#000000")
            padding(vertical = 10.px)
        }

        val contentDescription: CSSBuilder.() -> Unit = {
            fontFamily = "sans-serif"
            fontSize = 14.px
            color = Color("#888")
            lineHeight = 18.px.lh
        }

    }

}
