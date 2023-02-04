object Dependencies {

    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appcompat}" }
    val kotlin by lazy { "androidx.core:core-ktx:${Versions.kotlin}" }
    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val junit by lazy { "junit:junit:${Versions.jUnit}" }
    val mviCore by lazy { "com.github.badoo.mvicore:mvicore:${Versions.mviCore}" }
    val mviCoreBinder by lazy { "com.github.badoo.mvicore:binder:${Versions.mviCore}" }
    val mviCoreAndroid by lazy { "com.github.badoo.mvicore:mvicore-android:${Versions.mviCore}" }
    val mviCoreDiff by lazy { "com.github.badoo.mvicore:mvicore-diff:${Versions.mviCore}" }
    val mviCoreDebugDrawer by lazy { "com.github.badoo.mvicore:mvicore-debugdrawer:${Versions.mviCore}" }
    val composeThemeAdapter by lazy { "com.google.android.material:compose-theme-adapter:${Versions.composeThemeAdapter}" }
    val appCompatTheme by lazy { "com.google.accompanist:accompanist-appcompat-theme:${Versions.appCompatTheme}" }
    val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}" }
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val retrofitConvertor by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }
    val coil by lazy { "io.coil-kt:coil-compose:${Versions.coil}" }
    val viewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}" }
    val livedata by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}" }
    val common_java8 by lazy { "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}" }
    val lifecycleKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycleKtx}" }
    val compose by lazy { "androidx.activity:activity-compose:${Versions.compose}" }
    val extJunit by lazy { "androidx.test.ext:junit${Versions.extJunit}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }
    val splashScreen by lazy { "androidx.core:core-splashscreen:${Versions.splashScreen}" }
    val navigation by lazy { "androidx.navigation:navigation-compose:${Versions.navigation}" }
    val dataStore by lazy { "androidx.datastore:datastore-preferences:${Versions.dataStore}" }
    val composeTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.composeVersion}" }
    val composeUITest by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}" }
    val toolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}" }
    val materialCompose by lazy { "androidx.compose.material:material:${Versions.composeVersion}" }
    val composeUI by lazy { "androidx.compose.ui:ui:${Versions.composeVersion}" }
    val coroutine by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}" }
    val okhttpLogsInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpInterceptor}" }
    val okhttp by lazy { "com.squareup.okhttp3:okhttp:${Versions.okhttp}" }
    val gson by lazy { "com.google.code.gson:gson:${Versions.gson}" }

    val hiltCompilr by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}" }
    val hiltNavigationComponent by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavComponent}" }
    val composeViewModelLifecycle by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleCompose}" }
    val runtimeLiveData by lazy { "androidx.compose.runtime:runtime-livedata:${Versions.runtimeLiveData}" }
}
