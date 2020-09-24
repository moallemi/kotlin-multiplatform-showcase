import kotlinx.css.Color
import kotlinx.css.ObjectFit
import kotlinx.css.borderRadius
import kotlinx.css.borderTopLeftRadius
import kotlinx.css.borderTopRightRadius
import kotlinx.css.height
import kotlinx.css.margin
import kotlinx.css.objectFit
import kotlinx.css.padding
import kotlinx.css.pct
import kotlinx.css.properties.boxShadow
import kotlinx.css.px
import kotlinx.css.width
import react.RProps
import react.dom.b
import react.dom.h4
import react.dom.p
import react.functionalComponent
import styled.css
import styled.styledDiv
import styled.styledImg

external interface CardProps : RProps {
    var name: String
    var summary: String
    var bannerUrl: String?
}

val card = functionalComponent<CardProps> { props ->
    styledDiv {
        css {
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
        styledImg(src = props.bannerUrl, alt = "HeaderImage") {
            css {
                width = 100.pct
                height = 100.px
                objectFit = ObjectFit.cover
                borderTopLeftRadius = 5.px
                borderTopRightRadius = 5.px
            }
        }

        styledDiv {
            css {
                padding = "2px 16px;"
            }
            h4 { b { +props.name } }
            p { +props.summary }
        }

    }
}