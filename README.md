This is a Kotlin Multiplatform project targeting Android, iOS.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

* `/shared` is for the code that will be shared between all targets in the project.
  The most important subfolder is `commonMain`. If preferred, you can add code to the platform-specific folders here too.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…


* Add MOKO (Modern Kotlin), library used to cater Kotlin Multiplatform Mobile (KMM)
- root build.gradle.kts -  
```
buildscript {
  dependencies {
    classpath("dev.icerock.moko:resources-generator:0.23.0")
  }
}
```

Add dependencies in shared build.gradle.kts
- add plugin
```agsl
    id("dev.icerock.mobile.multiplatform-resources")
```
- common main dependencies
```agsl
    commonMain.dependencies {
        // put your Multiplatform dependencies here
        api("dev.icerock.moko:resources:0.23.0")
    }
```

- ios dependencies 
```agsl
      export("dev.icerock.moko:resources:0.23.0")
      export("dev.icerock.moko:graphics:0.9.0")
```

- string.xml under shared/commonMain/resources/MR/base/string.xml
- for localised language shared/commonMain/resources/MR/{country_code}/string.xml
- Strings.kt under commonMain/kotlin, define the expect class
- Actual classes under androidMain & iosMain

