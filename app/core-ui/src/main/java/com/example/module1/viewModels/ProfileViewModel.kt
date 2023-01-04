package com.example.module1.viewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.module1.data.ProfileRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(
    application: Application,
) : ViewModel() {

    private val profileRepository = ProfileRepositoryImpl.getInstance(application)

    fun saveInput(input: String) {

        viewModelScope.launch(Dispatchers.IO) {
            profileRepository.saveInput(input)
        }
    }
}
