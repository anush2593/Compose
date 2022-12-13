package com.example.module1.domain

interface ProfileRepository {
    suspend fun saveInput(input: String)
}
