package com.example.ui.domain

interface ProfileRepository {
    suspend fun saveInput(input: String)
}
