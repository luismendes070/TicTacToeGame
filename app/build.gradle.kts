plugins {
    id("com.android.application")
    // id("org.jetbrains.kotlin.android")
    kotlin("android") // Plugin with id 'org.jetbrains.kotlin.android' was already requested at line 1
    // id("com.gradle.enterprise")// not found
}

android {
    namespace = "com.github.luismendes070.tictactoegame"
    compileSdk = 34

    // BingChat
    // resourcesPackagingOptions {
       // excludes.add("META-INF/LICENSE")
    // }

    // Bard
    // packagingOptions {
       // exclude 'kotlin/internal/internal.kotlin_builtins'
    // }

    defaultConfig {
        applicationId = "com.github.luismendes070.tictactoegame"
        minSdk = 26
        targetSdk = 34
        versionCode = 35
        versionName = "1.43"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
    composeOptions{
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    dependenciesInfo {
        includeInApk = true
        includeInBundle = true
    }
    buildToolsVersion = "34.0.0"
    ndkVersion = "25.2.9519653"

}

dependencies {

    // docs expresso https://developer.android.com/training/testing/espresso/setup#kts
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")

    // docs https://developer.android.com/training/testing/instrumented-tests
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")

    // Bard
    implementation("androidx.compose.ui:ui-test-junit4-android:1.5.1")

    // https://mvnrepository.com/artifact/androidx.compose.material/material-icons-core
    runtimeOnly("androidx.compose.material:material-icons-core:1.5.1")

    // implementation("androidx.compose.material3:material3-icons:1.1.2")
    // Bard LazyVerticalGrid
    // implementation("androidx.compose.foundation:foundation-lazy:1.5.1")

    // https://mvnrepository.com/artifact/androidx.compose.foundation/foundation
    runtimeOnly("androidx.compose.foundation:foundation:1.5.1")

    // https://github.com/luismendes070/basic-android-kotlin-compose-training-unscramble
    implementation(platform("androidx.compose:compose-bom:2023.09.00"))
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.compose.material3:material3:1.1.1")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation("androidx.compose.ui:ui-test-junit4-android:1.5.1")

    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.1")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // testImplementation("junit:junit:4.13.2")

    // docs https://developer.android.com/games/pgs/android/android-start
    implementation("com.google.android.gms:play-services-games-v2:19.0.0")

    // Kotlin Flow Producer-Consumer Two Screens https://youtu.be/0G_1XCRlpYM
    // https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-coroutines-test
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")

    //Baeldung https://www.baeldung.com/kotlin/ktlint-code-formatting
    // implementation("org.jlleitschuh.gradle:ktlint-gradle:7.1.0")

    // Bard
    testImplementation("androidx.test.ext:junit:1.1.5")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    // Failed to resolve
    //implementation("org.gradle.enterprise:gradle-enterprise-gradle-plugin:3.5.1") // mavenCentral
    implementation("androidx.test.ext:junit-ktx:1.1.5")
    // ChatGPT
    implementation("com.pinterest:ktlint:0.50.0")
    implementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    testImplementation(project(mapOf("path" to ":app")))
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")
    // implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.recyclerview:recyclerview:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.2")
    // testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
