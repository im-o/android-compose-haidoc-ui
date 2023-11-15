import dependencies.MyDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "id.rivaldy.feature.auth"
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
    implementation(project(Modules.core))

    // Testing
    testImplementation(MyDependencies.junit)
    androidTestImplementation(MyDependencies.test_ext_junit)
    androidTestImplementation(MyDependencies.espresso_core)
    androidTestImplementation(platform(MyDependencies.compose_bom))
    androidTestImplementation(MyDependencies.junit_compose)
    debugImplementation(MyDependencies.ui_tooling)
    debugImplementation(MyDependencies.ui_test_manifest)

    // Hilt
    implementation(MyDependencies.hilt_android)
    kapt(MyDependencies.hilt_android_compiler)
    kapt(MyDependencies.hilt_compose_compiler)
}