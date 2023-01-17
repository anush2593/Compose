package com.example.feature_github.data

import com.example.feature_github.domain.GithubUserInfo
import kotlinx.coroutines.flow.Flow

internal interface GithubRemoteDataSource {
    suspend fun getGitHubUsers(): Flow<List<GithubUserInfo>>
}
