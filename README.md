# Kotlin Multiplatform Showcase

<img src="https://github.com/moallemi/kmp-showcase/blob/master/.github/kmp-showcase.png?raw=true">

A minimal app illustrating **Kotlin Multiplatform**. Currently running on
* Android
* iOS
* Web (in progress)
* macOS (TODO)
* CLI (TODO)

<img src="https://github.com/moallemi/kmp-showcase/blob/master/.github/android-ios-screenshot.png?raw=true">

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

Note that this repository may have not used the best practices on android or iOS implementation to help more clearly illustrate key parts of a Kotlin
Multiplatform project and also to help someone just starting to explore KMP for the first time.

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

Once you setup the project, you might want to change server address in your `~/.gradle/gradle.properties`:

```
KMP_SHOWCASE_API_BASE_URL_DEFAULT=<insert> // default: http://localhost:9090
KMP_SHOWCASE_API_BASE_URL_ANDROID=<insert> // default: http://10.0.2.2:9090
KMP_SHOWCASE_API_BASE_URL_IOS=<insert> // default: http://127.0.0.1:9090
```

## Contributions

If you've found an error in this sample, please file an issue.

Patches are encouraged, and may be submitted by forking this project and
submitting a pull request. Since this project is still in its very early stages,
if your change is substantial, please raise an issue first to discuss it.


