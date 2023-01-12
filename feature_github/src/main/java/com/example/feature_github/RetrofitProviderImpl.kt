package com.example.feature_github

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

internal class RetrofitProviderImpl(
    private val context: Context,
    private val gsonConverterFactory: GsonConverterFactory
) : RetrofitProvider {

    override fun provideBaseRetrofit(paramsProvider: NetworkParamsProvider): Retrofit {
        val loggingInterceptor =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

        val okHttpBuilder = OkHttpClient().newBuilder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(TIMEOUT_SECS, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT_SECS, TimeUnit.SECONDS)

        okHttpBuilder.addInterceptor(createHttpLoggerInterceptor(context))

        okHttpBuilder.addInterceptor { chain ->
            val request = chain.request()
            val response = chain.proceed(request)

            response
        }

        val builder = Retrofit.Builder()
            .baseUrl(paramsProvider.baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpBuilder.build())

        return builder.build()
    }

    companion object {
        private const val TIMEOUT_SECS: Long = 60
    }
}
