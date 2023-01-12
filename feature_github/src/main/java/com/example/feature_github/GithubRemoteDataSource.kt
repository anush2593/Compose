package com.example.feature_github

import com.example.core.Result

internal interface GithubRemoteDataSource {
    suspend fun getGitHubUsers(): Result<GithubUserResponse>
}
