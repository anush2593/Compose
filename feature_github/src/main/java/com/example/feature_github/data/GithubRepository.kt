package com.example.feature_github.data

import com.example.feature_github.domain.BaseApiResponse
import com.example.feature_github.domain.GithubUserInfo
import com.example.feature_github.domain.GithubUserResponse
import com.example.feature_github.domain.NetworkResult
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class GithubRepository @Inject constructor(
    val githubRemoteDataSource: GithubRemoteDataSource
) : BaseApiResponse() {

    suspend fun fetchUser(): Flow<NetworkResult<GithubUserResponse>> {
        return flow {
            emit(safeApiCall { githubRemoteDataSource.getGitHubUser() })
        }.flowOn(Dispatchers.IO)
    }
}
