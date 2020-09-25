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
        css(Styles.appList)
        child(Banner)
        props.apps.forEach { item ->
            child(card) {
                attrs.name = item.name
                attrs.summary = item.summary
                attrs.bannerUrl = item.bannerUrl
            }
        }
    }
}