package com.example.ui.viewModels

import androidx.lifecycle.ViewModel

open class BaseViewModel<T> : ViewModel() {

    override fun onCleared() {
        super.onCleared()
    }

    open fun perform(input: T) {}
}
