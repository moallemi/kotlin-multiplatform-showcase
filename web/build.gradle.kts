plugins {
    kotlin("js")
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation(project(":shared"))
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