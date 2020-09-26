plugins {
    kotlin("js")
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.2")
    implementation(project(":shared"))
}

kotlin {
    js {
        useCommonJs()
        browser {
            runTask {
                outputFileName = "web.js"
            }
        }
        binaries.executable()
    }
}