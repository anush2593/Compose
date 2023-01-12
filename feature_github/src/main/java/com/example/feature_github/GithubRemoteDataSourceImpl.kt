package com.example.feature_github

import com.example.core.Result

internal class GithubRemoteDataSourceImpl(
    private val githubApiService: GithubApiService,
    private val errorMapper: ErrorMapper,
    private val githubUserMapper: GithubUserMapper

) : GithubRemoteDataSource {
    override suspend fun getGitHubUsers(): Result<GithubUserResponse> {
        return githubApiService.getGitHubUsers()
    }
}
