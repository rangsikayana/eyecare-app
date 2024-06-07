package com.submission.eyecare.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.submission.eyecare.data.UserRepos
import kotlinx.coroutines.launch

class ProfileViewModel(private val repo: UserRepos): ViewModel() {

    fun getTheme(): LiveData<Boolean> {
        return repo.getTheme().asLiveData()
    }

    fun saveTheme(isDark: Boolean) {
        viewModelScope.launch {
            repo.saveTheme(isDark)
        }
    }

}