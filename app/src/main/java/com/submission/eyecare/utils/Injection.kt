package com.submission.eyecare.utils

import android.content.Context
import com.submission.eyecare.data.UserPreference
import com.submission.eyecare.data.UserRepos
import com.submission.eyecare.data.dataStore

object Injection {
    fun provideRepository(context: Context): UserRepos {
        val pref = UserPreference.getInstance(context.dataStore)
        return UserRepos.getInstance(pref)
    }
}