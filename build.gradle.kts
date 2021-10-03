buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.kotlinGradlePlugin)
        classpath(Dependencies.androidGradlePlugin)
        classpath(Dependencies.kotlinSerialization)
    }
}
group = "me.moallemi.kmpshowcase"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven") }
    }
}
