package com.example.feature_github.domain

import com.example.feature_github.data.GithubApiService
import com.example.feature_github.data.GithubRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class GithubRemoteDataSourceImpl @Inject constructor(
    private val githubApiService: GithubApiService
) : GithubRemoteDataSource {
    override suspend fun getGitHubUser(): Response<GithubUserResponse> {
        return githubApiService.getGitHubUser()
    }
}
