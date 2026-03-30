plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
}

android {
    namespace = "com.nhatnguyenba.newsapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.nhatnguyenba.newsapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(project(":features:home"))
    implementation(project(":features:detail"))
    implementation(project(":features:search"))
    implementation(project(":features:bookmark"))

    implementation(project(":data:news"))
    implementation(project(":domain:news"))

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material.icons.extended)

//    implementation(libs.hilt)
//    kapt(libs.hilt.compiler)
//    implementation(libs.androidx.hilt.navigation.compose)

    implementation("androidx.navigation:navigation-compose:2.8.7")

    implementation(libs.koin.android)
    implementation(libs.koin.compose)
}