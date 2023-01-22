package com.example.feature_github.di

import com.example.feature_github.DispatcherProvider
import com.example.feature_github.DispatcherProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatcherModule {
    @Binds
    @Singleton
    abstract fun bindDispatcher(
        dispatcher: DispatcherProviderImpl?
    ): DispatcherProvider?
}
