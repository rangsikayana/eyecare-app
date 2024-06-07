package com.submission.eyecare.data

data class UserModel(
    val email: String,
    val token: String,
    val isLogin: Boolean = false
)