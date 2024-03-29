plugins {
    kotlin("js")
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation(project(":shared"))

    //React, React DOM + Kotlin Wrappers
    implementation(Dependencies.KotlinWrappers.react)
    implementation(Dependencies.KotlinWrappers.reactDom)
    implementation(npm("react", "17.0.2"))
    implementation(npm("react-dom", "17.0.2"))

    //Styled + Kotlin Wrappers
    implementation(Dependencies.KotlinWrappers.styled)
    implementation(npm("styled-components", "~5.1.1"))
    implementation(npm("inline-style-prefixer", "~6.0.0"))

}

kotlin {
    js {
        useCommonJs()
        browser {
            runTask {
                outputFileName = "app.js"
            }
        }
        binaries.executable()
    }
}