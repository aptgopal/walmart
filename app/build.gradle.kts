plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.walmartsample"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.walmartsample"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        buildFeatures.buildConfig=true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        buildFeatures {
            viewBinding = true
        }
        buildConfigField ("String", "baseUrl",
            "\"https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/\""
        )
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildToolsVersion = "34.0.0"


}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    testImplementation ("org.mockito:mockito-core:3.0.0")
    testImplementation ("org.mockito:mockito-inline:3.0.0")
    testImplementation ("com.squareup.okhttp3:mockwebserver:4.9.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.0")
    implementation ("androidx.arch.core:core-testing:2.2.0")
    testImplementation ("org.mockito:mockito-core:3.0.0")
    testImplementation ("org.mockito:mockito-inline:3.0.0")
    //API dependencies
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.7.2")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //Coroutine
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
    implementation ("com.google.code.gson:gson:2.8.9")

    //viewModel
    implementation ("android.arch.lifecycle:extensions:1.1.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
}