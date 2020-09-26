pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        jcenter()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android" || requested.id.name == "kotlin-android-extensions") {
                useModule("com.android.tools.build:gradle:4.0.1")
            }
        }
    }
}
rootProject.name = "kmp-showcase"


include(":androidApp")
include(":shared")
include(":server")
include(":web")
include(":webReact")

if (System.getenv("KMP_SHOWCASE_DEPLOY_PROJECT")?.contains("web") == true) {
    include(":deploy")
}

enableFeaturePreview("GRADLE_METADATA")