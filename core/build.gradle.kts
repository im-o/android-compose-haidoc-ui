import dependencies.MyDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "id.rivaldy.core"
    compileSdk = Versions.compile_sdk

    defaultConfig {
        minSdk = Versions.min_sdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose_compiler
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    // some bug when using `kapt` in gradle 8.1.1 and replace jdk with jvmToolchain
    // https://github.com/google/ksp/issues/1288
    kotlin {
        jvmToolchain(11)
    }
}

dependencies {

    // Defaults Dependencies from Android Studio
    api(MyDependencies.core_ktx)
    api(MyDependencies.lifecycle_ktx)

    api(MyDependencies.activity_compose)
    api(platform(MyDependencies.compose_bom))
    api(MyDependencies.ui_compose)
    api(MyDependencies.ui_graphics)
    api(MyDependencies.ui_tooling_preview)
    api(MyDependencies.material3_compose)

    testImplementation(MyDependencies.junit)
    androidTestImplementation(MyDependencies.test_ext_junit)
    androidTestImplementation(MyDependencies.espresso_core)
    androidTestImplementation(platform(MyDependencies.compose_bom))
    androidTestImplementation(MyDependencies.junit_compose)
    debugImplementation(MyDependencies.ui_tooling)
    debugImplementation(MyDependencies.ui_test_manifest)

    // * Additional Dependencies *

    // UI
    api(MyDependencies.navigation_compose)
    api(MyDependencies.material_icons_extended)
    api(MyDependencies.constraintlayout_compose)

    // Remote
    api(MyDependencies.retrofit)
    api(MyDependencies.retrofit2_converter_gson)
    api(MyDependencies.retrofit2_adapter_rxjava2)
    api(MyDependencies.okhttp3)

    // Accompanist
    api(MyDependencies.accompanist_pager)
    api(MyDependencies.accompanist_pager_indicator)

    // Hilt
    implementation(MyDependencies.hilt_android)
    kapt(MyDependencies.hilt_android_compiler)
    api(MyDependencies.hilt_compose) {
        exclude("androidx.lifecycle")
    }
    kapt(MyDependencies.hilt_compose_compiler)
}