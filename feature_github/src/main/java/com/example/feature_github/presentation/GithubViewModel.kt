package com.example.feature_github.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_github.domain.GetGithubUsersUseCase
import com.example.feature_github.domain.GithubUserInfo
import com.example.feature_github.domain.GithubUserMapper
import com.example.feature_github.domain.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GithubViewModel @Inject constructor(
    val getGithubUsersUseCase: GetGithubUsersUseCase,
    private val githubUserMapper: GithubUserMapper
) : ViewModel() {

    private var _githubUser = MutableLiveData<NetworkResult<GithubUserInfo>>()
    var githubUser = _githubUser

    init {
        fetchGithubUser()
    }

    private fun fetchGithubUser() {
        viewModelScope.launch {
            getGithubUsersUseCase.invoke().collect {
                when (it) {
                    is NetworkResult.Success -> {
                        val response = githubUserMapper.map(it.data)
                        _githubUser.value = NetworkResult.Success(response)
                        Log.d("GithubViewModel", githubUser.value?.data.toString())
                    }
                    is NetworkResult.Error -> {
                        // show error message
                        Log.d("GithubViewModel", "Error")
                        //  TODO()
                    }
                    is NetworkResult.Loading -> {
                        // show a progress bar
                        Log.d("GithubViewModel", "Loading")
                        // TODO()
                    }
                }
            }
        }
    }
}
