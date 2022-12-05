package com.example.module1.repository

import android.content.Context

interface ProfileRepository {
    suspend fun saveInput(input: String)
}

class ProfileRepositoryImpl(
    context: Context,
) : ProfileRepository {

    override suspend fun saveInput(input: String) {
//        dataStore.edit { preferences ->
//            preferences[PreferenceKeys.NUMBER_INPUT] = input
//        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ProfileRepositoryImpl? = null

        fun getInstance(context: Context): ProfileRepositoryImpl {
            return INSTANCE ?: synchronized(this) {
                INSTANCE?.let {
                    return it
                }

                val instance = ProfileRepositoryImpl(context)
                INSTANCE = instance
                instance
            }
        }
    }
}
