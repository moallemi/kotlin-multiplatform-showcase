plugins {
    id("kotlin-platform-jvm")
    application
    kotlin("plugin.serialization")
}

dependencies {

    implementation("io.ktor:ktor-server-core:${Versions.ktor}")
    implementation("io.ktor:ktor-server-netty:${Versions.ktor}")
    implementation("io.ktor:ktor-serialization:${Versions.ktor}")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinxSerialization}")
    implementation ("ch.qos.logback:logback-classic:${Versions.logback}")
}

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}