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
    }
}
group = "me.moallemi.kmmshowcase"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
