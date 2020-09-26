# Contributing
Contributions of all types are welcome.
We use GitHub as our bug and feature tracker both for code and for other aspects of the project (documentation, the wiki, etc.).

## Contributing code
Pull requests are welcome for all parts of the codebase. we tried to keep code as simple as possible
You can find instructions on building the project in [README.md][1].

This project uses Kotlin Coding Conventions, provided via the bundled project IntelliJ codestyle.
If you find that one of your pull reviews does not pass the CI server check due to a code style conflict, you can review the problems and fix it by running: `./gradlew spotlessApply`, and run IntelliJ / Android Studio's code formatter.
If you'd like to submit code, but can't get the style checks to pass, feel free to put up your pull request anyway and we can help you fix the style issues.

## PR Guideline
1. Your PR must contain only one commit including all of your changes.
2. Please use appropriate format for you commit message like: `[AND] Handle screen orientation`. We have these labels for different sub projects in repository.
   * [AND] - for all changes related to `androidApp` project
   * [iOS] - for all changes related to `iosApp` project
   * [SERVER] - for all changes related to `server` project
   * [WEB] - for all changes related to `web` project
   * [WEB-REACT] - for all changes related to `webReact` project


[1]: https://github.com/moallemi/kotlin-multiplatform-showcase