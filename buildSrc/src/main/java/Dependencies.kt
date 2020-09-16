object Versions {
    const val kotlin = "1.4.10"
    const val androidxTest = "1.2.0"
    const val androidxTestExt = "1.1.1"
    const val androidGradlePlugin = "4.0.1" // manually update in root settings.gradle.kts
    const val constraintLayout = "2.0.0"
    const val appCompat = "1.2.0"
    const val coreKtx = "1.2.0"
    const val materialDesign = "1.2.0"
    const val junit = "4.13"
    const val koin = "3.0.1-alpha-2"
    const val kermit = "0.1.8"
    const val coroutines = "1.3.9-native-mt"

    object Android {
        const val minSdk = 21
        const val targetSdk = 30
        const val compileSdk = 30
        const val buildToolsVersion = "30.0.2"
    }
}

object Dependencies {
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val junit = "junit:junit:${Versions.junit}"

    const val kermit = "co.touchlab:kermit:${Versions.kermit}"
    const val koinCore = "org.koin:koin-core:${Versions.koin}"
    const val koinTest = "org.koin:koin-test:${Versions.koin}"

    object AndroidXTest {
        const val core = "androidx.test:core:${Versions.androidxTest}"
        const val junit = "androidx.test.ext:junit:${Versions.androidxTestExt}"
        const val runner = "androidx.test:runner:${Versions.androidxTest}"
        const val rules = "androidx.test:rules:${Versions.androidxTest}"
    }

    object KotlinTest {
        const val common = "org.jetbrains.kotlin:kotlin-test-common:${Versions.kotlin}"
        const val annotations = "org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.kotlin}"
        const val jvm = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
        const val junit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    }

    object Coroutines {
        const val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    }
}
