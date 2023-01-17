package com.example.feature_github.data

import com.example.feature_github.domain.GithubUserInfo
import kotlinx.coroutines.flow.Flow

internal class GithubRepository constructor(
    private val githubRemoteDataSource: GithubRemoteDataSource
) {

    suspend fun fetchUsers(): Flow<List<GithubUserInfo>> {
        return githubRemoteDataSource.getGitHubUsers()
    }
}
