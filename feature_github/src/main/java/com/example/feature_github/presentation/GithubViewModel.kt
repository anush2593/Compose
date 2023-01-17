package com.example.feature_github.presentation

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.example.core.BaseViewModel
import com.example.feature_github.domain.GetGithubUsersUseCase
import com.example.feature_github.domain.GithubUserInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

internal class GithubViewModel constructor(
    private val getGithubUsersUseCase: GetGithubUsersUseCase,
    application: Application
) : BaseViewModel(application) {

    private val _githubUsers = MutableStateFlow<List<GithubUserInfo>>(emptyList())
    val githubUsers = _githubUsers.asStateFlow()

    init {
        viewModelScope.launch {
            fetchGithubUsers()
        }
    }

    private suspend fun fetchGithubUsers() {
        getGithubUsersUseCase.invoke().onEach { result ->
            _githubUsers.value = result
        }.launchIn(viewModelScope)
    }
}
