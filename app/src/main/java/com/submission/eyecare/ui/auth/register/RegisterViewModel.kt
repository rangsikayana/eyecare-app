package com.submission.eyecare.ui.auth.register

import androidx.lifecycle.ViewModel
import com.submission.eyecare.data.UserRepos

class RegisterViewModel(private val repo: UserRepos): ViewModel () {
    fun register(email: String, password: String, firstName: String, lastName: String) = repo.register(email, password, firstName, lastName)
}