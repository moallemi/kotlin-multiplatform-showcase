import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlin-android-extensions")
    id("kotlinx-serialization")
    id("com.codingfeline.buildkonfig") version "0.7.0"
}
group = "me.moallemi.kmpshowcase"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}
kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }
    js {
        browser {
        }
    }

    sourceSets {
        all {
            languageSettings.apply {
                useExperimentalAnnotation("kotlin.RequiresOptIn")
                useExperimentalAnnotation("kotlinx.coroutines.ExperimentalCoroutinesApi")
                useExperimentalAnnotation("kotlinx.serialization.InternalSerializationApi")
            }
        }
        val commonMain by getting {
            dependencies {
                implementation(Dependencies.Koin.core)
                implementation(Dependencies.Coroutines.common)

                implementation(Dependencies.Ktor.commonCore)
                implementation(Dependencies.Ktor.commonJson)
                implementation(Dependencies.Ktor.commonLogging)
                implementation(Dependencies.Ktor.commonSerialization)

                implementation(Dependencies.kotlinxSerialization)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                api(Dependencies.coreKtx)
                implementation(Dependencies.Coroutines.test)

                implementation(Dependencies.Ktor.jvmCore)
                implementation(Dependencies.Ktor.jvmJson)
                implementation(Dependencies.Ktor.jvmLogging)
                implementation(Dependencies.Ktor.androidSerialization)
                implementation(Dependencies.Ktor.androidCore)

                implementation(Dependencies.LifeCycle.extensions)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation(Dependencies.junit)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(Dependencies.Koin.core)
                implementation(Dependencies.Coroutines.common) {
                    version {
                        strictly(Versions.coroutines)
                    }
                }
                implementation(Dependencies.Ktor.ios)
            }
        }
        val iosTest by getting

        val jsMain by getting {
            dependencies {
                api(Dependencies.Koin.core)
                api(Dependencies.Coroutines.common)
            }
        }
    }
}
android {
    compileSdkVersion(Versions.Android.compileSdk)
    buildToolsVersion(Versions.Android.buildToolsVersion)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(Versions.Android.minSdk)
        targetSdkVersion(Versions.Android.targetSdk)
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}
val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework =
        kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}
tasks.getByName("build").dependsOn(packForXcode)

apply(from = "buildKonfig.gradle")