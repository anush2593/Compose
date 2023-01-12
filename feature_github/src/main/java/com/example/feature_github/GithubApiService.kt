package com.example.feature_github

import com.example.core.Result
import retrofit2.http.GET

internal interface GithubApiService {

    @GET("users")
    suspend fun getGitHubUsers(): Result<ApiGithubResponse>
}
