package com.example.feature_github.data

import com.example.feature_github.ApiGithubResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

internal interface GithubApiService {

    @GET("users")
    suspend fun getGitHubUsers(): Flow<List<ApiGithubResponse>>
}
