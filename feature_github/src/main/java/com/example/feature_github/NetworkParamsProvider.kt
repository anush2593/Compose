package com.example.feature_github

interface NetworkParamsProvider {
    val baseUrl: String
    val language: String
    val appVersionName: String
    val androidVersionCode: String
    val deviceId: String
    val clientSecret: String
    val token: String?
    fun getDeviceName(): String
}
