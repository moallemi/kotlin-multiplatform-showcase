pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
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