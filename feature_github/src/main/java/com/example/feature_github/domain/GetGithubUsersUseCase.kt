package com.example.feature_github.domain

import com.example.feature_github.DispatcherProvider
import com.example.feature_github.data.GithubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

internal class GetGithubUsersUseCase constructor(
    private val dispatcherProvider: DispatcherProvider,
    private val githubRepository: GithubRepository
) {
    suspend operator fun invoke(): Flow<List<GithubUserInfo>> =
        withContext(dispatcherProvider.io) {
            githubRepository.fetchUsers()
        }
}
