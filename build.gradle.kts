buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.kotlinGradlePlugin)
        classpath(Dependencies.androidGradlePlugin)
        classpath(Dependencies.kotlinSerialization)
    }
}
group = "me.moallemi.kmmshowcase"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven(url = "https://dl.bintray.com/touchlabpublic/kotlin")
    }
}
