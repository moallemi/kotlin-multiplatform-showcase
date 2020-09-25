import kotlinx.css.Display
import kotlinx.css.FlexWrap
import kotlinx.css.JustifyContent
import kotlinx.css.display
import kotlinx.css.flexWrap
import kotlinx.css.justifyContent
import me.moallemi.kmpshowcase.shared.domain.model.App
import react.RProps
import react.child
import react.functionalComponent
import styled.css
import styled.styledDiv

external interface AppListProps : RProps {
    var apps: List<App>
}

val AppList = functionalComponent<AppListProps> { props ->
    styledDiv {
        css {
            display = Display.flex
            flexWrap = FlexWrap.wrap
            justifyContent = JustifyContent.center
        }
        props.apps.forEach { item ->
            child(card) {
                attrs.name = item.name
                attrs.summary = item.summary
                attrs.bannerUrl = item.bannerUrl
            }
        }
    }
}