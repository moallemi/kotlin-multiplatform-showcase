package component

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
        css(Styles.Card.root)
        styledDiv {
            css(Styles.Card.header)
            styledImg(src = props.bannerUrl, alt = "HeaderImage") {
                css(Styles.Card.headerImage)
            }
        }
        styledDiv {
            css(Styles.Card.content)
            styledDiv {
                css(Styles.Card.contentTitle)
                +props.name
            }
            styledDiv {
                css(Styles.Card.contentDescription)
                +props.summary
            }
        }
    }
}