package com.example.feature_bottom_nav.viewModels

import androidx.lifecycle.ViewModel

open class BaseViewModel<T> : ViewModel() {

    override fun onCleared() {
        super.onCleared()
    }

    open fun perform(input: T) {}
}
