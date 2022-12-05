package com.example.module1.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.module1.repository.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(private val repo: ProfileRepository) : ViewModel() {

    fun saveInput(input: String) {

        viewModelScope.launch(Dispatchers.IO) {
            repo.saveInput(input)
        }
    }
}
