package com.example.feature_bottom_nav.domain

interface ProfileRepository {
    suspend fun saveInput(input: String)
}
