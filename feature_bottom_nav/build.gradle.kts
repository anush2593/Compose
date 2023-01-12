plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.feature_bottom_nav"
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.1"
    }
}

dependencies {
    implementation(Dependencies.kotlin)
    implementation(Dependencies.composeUI)
    implementation(Dependencies.materialCompose)
    implementation(Dependencies.toolingPreview)
    androidTestImplementation(Dependencies.composeUITest)
    debugImplementation(Dependencies.composeTooling)
    implementation(Dependencies.lifecycleKtx)
    implementation(Dependencies.compose)
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.extJunit)
    androidTestImplementation(Dependencies.espresso)
    implementation(Dependencies.splashScreen)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.navigation)
    implementation(Dependencies.dataStore)
    implementation(project(":ui"))
}