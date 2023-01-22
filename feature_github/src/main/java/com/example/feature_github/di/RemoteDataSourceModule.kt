package com.example.feature_github.di

import com.example.feature_github.data.GithubRemoteDataSource
import com.example.feature_github.domain.GithubRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {
    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(
        remoteDataSource: GithubRemoteDataSourceImpl?
    ): GithubRemoteDataSource?
}
