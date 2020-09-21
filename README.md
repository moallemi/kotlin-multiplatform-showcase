# Kotlin Mulitplatform Showcase

A minimal app illustrating **Kotlin Multiplatform**. Currently running on
* Android
* iOS

## Project Structure

This project consists of several gradle modules as well as an xcode project.

### Shared

This is the central module which contains shared client code. It includes an Api class with a method to query the apps endpoint using the Ktor http client.

### Android

This is an Android project consuming the `:shared` module. It contains a single activity which calls the `viewModel.load()` function and displays its output in UI.

### iOS

The iOS app code is in the `iosApp` directory. It uses SwiftUI to render output to screen.

### Server

This is a simple Ktor server running on the Netty engine with a single endpoint `/api/v1/apps`, which outputs a list of `Apps` object serialized to JSON.

Note that this repository may have errors on the side of minimalism to help more clearly illustrate key moving parts of a Kotlin
Multiplatform project and also to help someone just starting to explore KMP to get up and running for the first time.

### Libraries and tools used

* [Kotlin Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
* [Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization)
* [Ktor client and server library](https://github.com/ktorio/ktor)
* [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/index.html)
* [Koin](https://github.com/InsertKoinIO/koin)
* [SwiftUI](https://developer.apple.com/documentation/swiftui)

### Development setup
* For development, the latest version of Android Studio 4.0+ is required.
* The iOS code can be modified or built by opening `iosApp/KmpShowcase.xcodeproj` in Xcode.
* Running `./gradlew server:run` will deploy the server to localhost on port 8080.

## Contributions

If you've found an error in this sample, please file an issue.

Patches are encouraged, and may be submitted by forking this project and
submitting a pull request. Since this project is still in its very early stages,
if your change is substantial, please raise an issue first to discuss it.


