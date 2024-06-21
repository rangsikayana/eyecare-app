package com.submission.eyecare.ui.auth.register

import androidx.lifecycle.ViewModel
import com.submission.eyecare.data.UserRepos

class RegisterViewModel(private val repo: UserRepos) : ViewModel() {
    fun register(firstName: String, lastName: String, email: String, password: String) =
        repo.register(firstName, lastName, email, password)
}