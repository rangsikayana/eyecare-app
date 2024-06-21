package com.submission.eyecare.data

import androidx.lifecycle.liveData
import com.google.gson.Gson
import com.submission.eyecare.data.local.IshiharaPlate
import com.submission.eyecare.data.local.LoginResult
import com.submission.eyecare.data.local.PlateData
import com.submission.eyecare.data.local.UserDisplayName
import com.submission.eyecare.data.network.ApiService
import com.submission.eyecare.data.network.response.ErrorResponse
import com.submission.eyecare.data.network.response.LoginResponse
import com.submission.eyecare.data.network.response.PredictResponse
import com.submission.eyecare.utils.Result
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import retrofit2.HttpException

class UserRepos private constructor(
    private val userPreference: UserPreference,
    private val api1: ApiService,
    private val api2: ApiService
) {


    suspend fun saveName(name: UserDisplayName) {
        userPreference.saveName(name)
    }

    fun getName(): Flow<UserDisplayName> {
        return userPreference.getName()
    }

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

    suspend fun saveTheme(isDark: Boolean) {
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
            val response = api1.login(email, password)
            val uid = response.user?.uid
            val name = response.user?.displayName
            emit(Result.Success(LoginResult(uid, name)))
        } catch (e: HttpException) {
            val jsonString = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonString, LoginResponse::class.java)
            val eMsg = errorBody.message.toString()
            emit(Result.Error(eMsg))
        }
    }

    fun register(
        firstName: String,
        lastName: String,
        email: String,
        password: String,
    ) = liveData {
        emit(Result.Loading)
        try {
            val response = api1.register(firstName, lastName, email, password)
            val msg = response.message
            emit(Result.Success(msg))
        } catch (e: HttpException) {
            val eMsg: String
            when (e.code()) {
                400 -> {
                    eMsg = "Bad Request"
                    emit(Result.Error(eMsg))
                }

                408 -> {
                    eMsg = "Connection Problem, Try Again"
                    emit(Result.Error(eMsg))
                }

                else -> {
                    val jsonString = e.response()?.errorBody()?.string()
                    val errorBody = Gson().fromJson(jsonString, ErrorResponse::class.java)
                    eMsg = errorBody.message.toString()
                    emit(Result.Error(eMsg))
                }
            }
        }
    }

    suspend fun uploadImage(file: MultipartBody.Part): PredictResponse {
        return api2.uploadImage(file)
    }


    companion object {

        @Volatile
        private var instance: UserRepos? = null
        fun getInstance(
            userPreference: UserPreference,
            api1: ApiService,
            api2: ApiService
        ): UserRepos =
            instance ?: synchronized(this) {
                instance ?: UserRepos(userPreference, api1, api2)
            }.also { instance = it }
    }

}