package com.example.feature_github.domain

import com.example.feature_github.data.GithubApiService
import com.example.feature_github.data.GithubRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class GithubRemoteDataSourceImpl constructor(
    private val githubApiService: GithubApiService,
    private val errorMapper: ErrorMapper,
    private val githubUserMapper: GithubUserMapper
) : GithubRemoteDataSource {
    override suspend fun getGitHubUsers(): Flow<List<GithubUserInfo>> {
        return githubApiService.getGitHubUsers().map { result ->
            githubUserMapper.map(result)
        }
    }
}
