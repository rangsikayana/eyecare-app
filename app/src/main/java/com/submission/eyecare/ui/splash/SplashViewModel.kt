package com.submission.eyecare.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.submission.eyecare.data.UserModel
import com.submission.eyecare.data.UserRepos

class SplashViewModel(private val repo: UserRepos) : ViewModel() {
    fun getTheme(): LiveData<Boolean> {
        return repo.getTheme().asLiveData()
    }

    fun fetchSession(): LiveData<UserModel> {
        return repo.getSession().asLiveData()
    }
}