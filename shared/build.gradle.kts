
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id(libs.plugins.mokoSharedResources.get().pluginId)
}

kotlin {

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
//    cocoapods {
//        version = "1.0"
//        summary = "Some description for the Shared Module"
//        homepage = "Link to the Shared Module homepage"
//        ios.deploymentTarget = "17.0"
//    }

    targets.withType(org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget::class.java).all {
        binaries.withType(org.jetbrains.kotlin.gradle.plugin.mpp.Framework::class.java).all {
            baseName = "MultiPlatformLibrary"
            export(libs.moko.mvvm.core)
            export(libs.moko.mvvm.flow)
        }
    }


    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
            export("dev.icerock.moko:resources:0.23.0")
            export("dev.icerock.moko:graphics:0.9.0")
        }
    }

//    iosX64()
//    iosArm64()
//    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            // put your Multiplatform dependencies here
            api("dev.icerock.moko:resources:0.23.0")
            // moko mvvm
            api(libs.moko.mvvm.core)
            api(libs.moko.mvvm.livedata)
            api(libs.moko.mvvm.livedata.resources)
            api(libs.moko.mvvm.state)
            api(libs.moko.mvvm.flow)
            api(libs.moko.mvvm.flow.resources)
            implementation(libs.koin.core)
        }
        androidMain {
            dependsOn(commonMain.get())
            dependencies {
                implementation(libs.koin.android)
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain.get())
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }

    }
}

android {
    namespace = "org.pratha.bits.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "org.pratha.bits" // required
}