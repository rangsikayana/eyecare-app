package com.submission.eyecare.ui.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.submission.eyecare.data.UserModel
import com.submission.eyecare.data.UserRepos
import com.submission.eyecare.data.local.UserDisplayName
import kotlinx.coroutines.launch

class LoginViewModel(private val repo: UserRepos) : ViewModel() {
    fun login(email: String, password: String) = repo.login(email, password)

    fun saveSession(user: UserModel) {
        viewModelScope.launch {
            repo.saveSession(user)
        }
    }

    fun saveName(name: UserDisplayName) {
        viewModelScope.launch {
            repo.saveName(name)
        }
    }

}