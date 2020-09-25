import kotlinx.css.Align
import kotlinx.css.Color
import kotlinx.css.Display
import kotlinx.css.FlexDirection
import kotlinx.css.ObjectFit
import kotlinx.css.alignSelf
import kotlinx.css.backgroundColor
import kotlinx.css.borderRadius
import kotlinx.css.borderTopLeftRadius
import kotlinx.css.borderTopRightRadius
import kotlinx.css.color
import kotlinx.css.display
import kotlinx.css.flexDirection
import kotlinx.css.fontFamily
import kotlinx.css.fontSize
import kotlinx.css.height
import kotlinx.css.lineHeight
import kotlinx.css.margin
import kotlinx.css.objectFit
import kotlinx.css.padding
import kotlinx.css.pct
import kotlinx.css.properties.boxShadow
import kotlinx.css.properties.lh
import kotlinx.css.px
import kotlinx.css.width
import react.RProps
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
        styledDiv {
            css {
                display = Display.flex
                flexDirection = FlexDirection.column
                width = 100.pct
                height = 100.px
                borderTopLeftRadius = 5.px
                borderTopRightRadius = 5.px
                backgroundColor = Color("#eaeaea")
            }

            styledImg(src = props.bannerUrl, alt = "HeaderImage") {
                css {
                    alignSelf = Align.center
                    width = 80.pct
                    height = 100.pct
                    objectFit = ObjectFit.scaleDown
                }
            }
        }

        styledDiv {
            css {
                padding = "2px 16px;"
            }
            styledDiv {
                css {
                    fontFamily = "sans-serif"
                    fontSize = 16.px
                    color = Color("#000000")
                    padding(vertical = 10.px)
                }
                +props.name
            }
            styledDiv {
                css {
                    fontFamily = "sans-serif"
                    fontSize = 14.px
                    color = Color("#888")
                    lineHeight = 18.px.lh
                }
                +props.summary
            }
        }

    }
}