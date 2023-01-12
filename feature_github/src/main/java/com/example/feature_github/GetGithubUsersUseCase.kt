package com.example.feature_github

import kotlinx.coroutines.CoroutineDispatcher

internal abstract class GetGithubUsersUseCase(coroutineDispatcher: CoroutineDispatcher) :
    FlowUseCase<Unit, GithubUserInfo>(coroutineDispatcher)
