plugins {
    id("kotlin-platform-jvm")
    application
    kotlin("plugin.serialization")
}

group = "me.moallemi.kmpshowcase.server"
version = "1.0.0"

dependencies {

    implementation("io.ktor:ktor-server-core:${Versions.ktor}")
    implementation("io.ktor:ktor-server-netty:${Versions.ktor}")
    implementation("io.ktor:ktor-serialization:${Versions.ktor}")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinxSerialization}")
    implementation("ch.qos.logback:logback-classic:${Versions.logback}")

    testImplementation("io.ktor:ktor-server-tests:${Versions.ktor}")
}

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

tasks.create("stage") {
    dependsOn(tasks.getByName("installDist"))
}