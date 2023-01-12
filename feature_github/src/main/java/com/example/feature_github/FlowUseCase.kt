package com.example.feature_github

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

abstract class FlowUseCase<in In, Out>(private val coroutineDispatcher: CoroutineDispatcher) {

    operator fun invoke(parameters: In): Flow<com.example.core.Result<Out>> = execute(parameters)
        .catch {
        }
        .flowOn(coroutineDispatcher)

    protected abstract fun execute(parameters: In): Flow<com.example.core.Result<Out>>
}

class DomainException(
    val error: Error,
    cause: Throwable? = null
) : Exception(error.toString(), cause)
