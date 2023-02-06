package com.example.feature_bottom_nav.viewModels

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.example.core.BaseViewModel
import com.example.feature_bottom_nav.data.ProfileRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(
    application: Application
) : BaseViewModel(application) {

    private val profileRepository = ProfileRepositoryImpl.getInstance(application)

    fun saveInput(input: String) {
        viewModelScope.launch(Dispatchers.IO) {
            profileRepository.saveInput(input)
        }
    }
}
