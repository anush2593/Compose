package com.example.feature_github.data

import com.example.feature_github.domain.GithubUserResponse
import retrofit2.Response

interface GithubRemoteDataSource {
    suspend fun getGitHubUser(): Response<GithubUserResponse>
}
