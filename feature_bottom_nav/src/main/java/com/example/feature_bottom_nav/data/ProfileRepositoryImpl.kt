package com.example.feature_bottom_nav.data

import android.annotation.SuppressLint
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.feature_bottom_nav.domain.ProfileRepository

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "sharedPrefs")
val EXAMPLE_INPUT = stringPreferencesKey("input")

class ProfileRepositoryImpl(
    mContext: Context
) : ProfileRepository {

    private val context = mContext
    override suspend fun saveInput(input: String) {
        context.dataStore.edit { sharedPrefs ->
            sharedPrefs[EXAMPLE_INPUT] = input
        }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
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
