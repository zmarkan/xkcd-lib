XKCD-LIB
==

Made with ❤️ for Onfido.

# Components:

- Library
- Sample app calling the library
- Integration tests between the 2

## Library

- written in Kotlin
- Lightweight API, doesn't use OnActivityResult
- Main point of entry is library/src/main/kotlin/com/zmarkan/xkcdlib/ComicViewer.kt

## Sample

- Written in Java
- Has Espresso tests testing integration between the two. Tests need a device or emulator to run, and work on both Genymotion and Android emulators.

# Running

From project main dir run: `./gradlew clean connectedAndroidTest` 
Run with `--info` for leet console output.
