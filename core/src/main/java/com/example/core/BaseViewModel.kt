package com.example.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

open class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private val _progressDialog = MutableStateFlow(false)
    public val progressDialog = _progressDialog.asStateFlow()

    override fun onCleared() {
        super.onCleared()
    }
}
