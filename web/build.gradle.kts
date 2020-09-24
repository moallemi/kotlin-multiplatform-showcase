plugins {
    kotlin("js")
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.2")
    implementation(project(":shared"))

    //React, React DOM + Wrappers
    implementation(Dependencies.KotlinWrappers.react)
    implementation(Dependencies.KotlinWrappers.dom)
    implementation(npm("react", "16.13.1"))
    implementation(npm("react-dom", "16.13.1"))

    //Kotlin Styled
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