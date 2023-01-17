plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.feature_github"
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
    implementation(Dependencies.coroutine)
    implementation(Dependencies.compose)
    implementation(Dependencies.composeUI)
    implementation(Dependencies.materialCompose)
    implementation(Dependencies.toolingPreview)
    debugImplementation(Dependencies.composeTooling)
    androidTestImplementation(Dependencies.composeUITest)
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.extJunit)
    androidTestImplementation(Dependencies.espresso)
    implementation(project(mapOf("path" to ":core")))
    implementation(project(":ui"))

    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitConvertor)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.okhttpLogsInterceptor)
    implementation(Dependencies.gson)
    implementation(Dependencies.viewModel)

    implementation(Dependencies.hilt)
    implementation(Dependencies.hiltCompiler)
}
