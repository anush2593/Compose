package com.example.feature_github.presentation

import com.example.feature_github.GetGithubUsersUseCase
import kotlinx.coroutines.flow.onEach

internal class GithubViewModel(
    private val getGithubUsersUseCase: GetGithubUsersUseCase
) {
    private fun getGithubUsers() {
        getGithubUsersUseCase.invoke(Unit).onEach { }
    }
}
