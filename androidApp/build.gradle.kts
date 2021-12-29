plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
    id ("kotlin-android-extensions")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.example.prohappymultiplatform.android"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation("androidx.navigation:navigation-runtime-ktx:2.3.5")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.navigation:navigation-fragment:2.3.5")
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.navigation:navigation-ui:2.3.5")

}