package com.example.feature_github.data

import com.example.feature_github.ApiGithubResponse
import retrofit2.Response
import retrofit2.http.GET

interface GithubApiService {

    @GET("users/willnorris")
    suspend fun getGitHubUser(): Response<ApiGithubResponse>
}
