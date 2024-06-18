package com.submission.eyecare.data

import androidx.lifecycle.liveData
import com.google.gson.Gson
import com.submission.eyecare.data.network.ApiService
import com.submission.eyecare.data.network.response.ErrorResponse
import com.submission.eyecare.data.network.response.LoginResponse
import com.submission.eyecare.utils.Result
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException

class UserRepos private constructor(
    private val userPreference: UserPreference, private val api: ApiService) {


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

    fun login(
        email: String,
        password: String
    ) = liveData {
        emit(Result.Loading)
        try {
            val response = api.login(email, password)
            val uid = response.user?.uid
            emit(Result.Success(uid))
        } catch (e: HttpException){
            val jsonString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonString, LoginResponse::class.java)
            val eMsg = errorBody.message.toString()
            emit(Result.Error(eMsg))
        }
    }

    fun register(
        email: String,
        password: String,
        firstName: String,
        lastName: String
    ) = liveData {
        emit(Result.Loading)
        try {
            val response = api.register(email, password, firstName, lastName)
            val msg = response.message
            emit(Result.Success(msg))
        } catch (e: HttpException) {
            val eMsg : String
            when (e.code()) {
                400 -> { eMsg = "Bad Request"
                    emit(Result.Error(eMsg)) }
                408 -> { eMsg = "Connection Problem, Try Again"
                    emit(Result.Error(eMsg))}
                else -> {
                    val jsonString = e.response()?.errorBody()?.string()
                    val errorBody = Gson().fromJson(jsonString, ErrorResponse::class.java)
                    eMsg = errorBody.message.toString()
                    emit(Result.Error(eMsg))
                }
            }
        }
    }
    companion object {

        @Volatile
        private var instance: UserRepos? = null
        fun getInstance(userPreference: UserPreference, api: ApiService): UserRepos =
            instance ?: synchronized(this) {
                instance ?: UserRepos(userPreference, api)
            }.also { instance = it }
    }

}