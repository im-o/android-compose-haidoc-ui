package dependencies

/** Created by github.com/im-o on 11/15/2023. */

object MyDependencies {

    // Default Dependencies
    const val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx_version}"
    const val lifecycle_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_ktx_version}"
    const val activity_compose = "androidx.activity:activity-compose:${Versions.activity_compose_version}"
    const val compose_bom = "androidx.compose:compose-bom:${Versions.compose_bom_version}"
    const val ui_compose = "androidx.compose.ui:ui"
    const val ui_graphics = "androidx.compose.ui:ui-graphics"
    const val ui_tooling_preview = "androidx.compose.ui:ui-tooling-preview"
    const val material3_compose = "androidx.compose.material3:material3"

    const val junit = "junit:junit:${Versions.junit_version}"
    const val test_ext_junit = "androidx.test.ext:junit:${Versions.test_ext_junit_version}"
    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_test_version}"
    const val junit_compose = "androidx.compose.ui:ui-test-junit4"
    const val ui_tooling = "androidx.compose.ui:ui-tooling"
    const val ui_test_manifest = "androidx.compose.ui:ui-test-manifest"

    // UI
    const val material_icons_extended = "androidx.compose.material:material-icons-extended"
    const val navigation_compose = "androidx.navigation:navigation-compose:${Versions.navigation_compose}"
    const val constraintlayout_compose = "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintlayout_compose_version}"

    // Remote
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
    const val retrofit2_converter_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit_version}"
    const val retrofit2_adapter_rxjava2 = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit_version}"
    const val okhttp3 = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp3_version}"

    // Hilt
    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt_android}"
    const val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt_android}"
    const val hilt_compose = "androidx.hilt:hilt-navigation-compose:${Versions.hilt_compose}"
    const val hilt_compose_compiler = "androidx.hilt:hilt-compiler:${Versions.hilt_compose}"

    // Pager
    const val accompanist_pager = "com.google.accompanist:accompanist-pager:${Versions.compose_accompanist_version}"
    const val accompanist_pager_indicator = "com.google.accompanist:accompanist-pager-indicators:${Versions.compose_accompanist_version}"
}