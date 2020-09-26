plugins {
    id("kotlin-platform-jvm")
    application
    kotlin("plugin.serialization")
}

group = "me.moallemi.kmpshowcase.weebrunner"
version = "1.0.0"

dependencies {

    implementation("io.ktor:ktor-server-core:${Versions.ktor}")
    implementation("io.ktor:ktor-server-netty:${Versions.ktor}")
    implementation("ch.qos.logback:logback-classic:${Versions.logback}")
}

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

tasks.create("copyDistributionDirectory") {
    dependsOn(tasks.getByPath(":web:build"))
    doLast {
        copy {
            from("../web/build/distributions")
            into("src/main/resources")
        }
    }
}

tasks.create("stage") {
    dependsOn(tasks.getByName("installDist"))
}

tasks.getByPath(":deploy:processResources").dependsOn(tasks.getByPath("copyDistributionDirectory"))