package com.submission.eyecare.data

import kotlinx.coroutines.flow.Flow

class UserRepos private constructor(private val userPreference: UserPreference) {


    suspend fun saveSession(user: UserModel) {
        userPreference.saveSession(user)
    }

    fun getSession(): Flow<UserModel> {
        return userPreference.getSession()
    }

    suspend fun logout() {
        userPreference.logout()
        instance = null
    }

    fun getTheme(): Flow<Boolean> {
        return userPreference.getTheme()
    }

    suspend fun saveTheme(isDark : Boolean) {
        userPreference.saveTheme(isDark)
    }

    fun getPlates(): List<IshiharaPlate> {
        return PlateData.plates
    }

    companion object {

        @Volatile
        private var instance: UserRepos? = null
        fun getInstance(userPreference: UserPreference): UserRepos =
            instance ?: synchronized(this) {
                instance ?: UserRepos(userPreference)
            }.also { instance = it }
    }

}