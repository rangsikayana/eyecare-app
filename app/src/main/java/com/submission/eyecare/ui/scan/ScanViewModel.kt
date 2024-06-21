package com.submission.eyecare.ui.scan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.submission.eyecare.data.UserRepos
import com.submission.eyecare.data.network.response.Error
import com.submission.eyecare.data.network.response.PredictResponse
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import retrofit2.HttpException
import java.net.ProtocolException

class ScanViewModel(private val repo: UserRepos) : ViewModel() {
    private val _uploadResult = MutableLiveData<PredictResponse?>()
    val uploadResult: LiveData<PredictResponse?> = _uploadResult

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun uploadImage(file: MultipartBody.Part) {
        _isLoading.value = true
        viewModelScope.launch {
            val maxRetries = 3
            var currentRetry = 0
            var success = false

            while (currentRetry < maxRetries && !success) {
                try {
                    val response = repo.uploadImage(file)
                    _uploadResult.value = response
                    success = true
                } catch (e: HttpException) {
                    val errorBody = e.response()?.errorBody()?.string()
                    if (errorBody != null) {
                        val errorResponse = Gson().fromJson(errorBody, Error::class.java)
                        _error.value = errorResponse?.error?.toString() ?: "Unknown error occurred"
                    } else {
                        _error.value = "Error body is null"
                    }
                } catch (e: ProtocolException) {
                    _error.value = "Network error occurred. Retrying..."
                } catch (e: Exception) {
                    _error.value = "An unexpected error occurred: ${e.message}"
                } finally {
                    _isLoading.value = false
                    currentRetry++
                }
            }
        }
    }
}

