package com.example.feature_github

import com.example.core.Result
import kotlinx.coroutines.flow.Flow

internal class GetGithubUsersUseCaseImpl(
    dispatcherProvider: DispatcherProvider

) : GetGithubUsersUseCase(dispatcherProvider.io) {
    override fun execute(parameters: Unit): Flow<Result<GithubUserInfo>> {
        TODO("Not yet implemented")
    }
}
