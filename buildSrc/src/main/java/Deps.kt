
object Dependencies {

    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appcompat}" }
    val kotlin by lazy { "androidx.core:core-ktx::${Versions.kotlin}" }
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
    val coil by lazy { "io.coil-kt:coil-compose:${Versions.coil}" }
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val common_java8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
}
