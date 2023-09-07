plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
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
        versionCode = 11
        versionName = "1.18"

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
    dependenciesInfo {
        includeInApk = true
        includeInBundle = true
    }
    buildToolsVersion = "34.0.0"
    ndkVersion = "25.2.9519653"
}

dependencies {

    // Kotlin Flow Producer-Consumer Two Screens https://youtu.be/0G_1XCRlpYM
    // https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-coroutines-test
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")

    //Baeldung https://www.baeldung.com/kotlin/ktlint-code-formatting
    // implementation("org.jlleitschuh.gradle:ktlint-gradle:7.1.0")

    // Bard
    implementation("org.gradle.enterprise:gradle-enterprise-gradle-plugin:3.13")
    implementation("androidx.test.ext:junit-ktx:1.1.5")
    // ChatGPT
    implementation("com.pinterest:ktlint:0.50.0")
    implementation("androidx.test.espresso:espresso-core:3.5.1")
    testImplementation(project(mapOf("path" to ":app")))
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.recyclerview:recyclerview:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.1")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
