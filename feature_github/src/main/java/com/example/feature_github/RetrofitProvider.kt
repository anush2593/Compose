package com.example.feature_github

import retrofit2.Retrofit

interface RetrofitProvider {
    fun provideBaseRetrofit(paramsProvider: NetworkParamsProvider): Retrofit
}
