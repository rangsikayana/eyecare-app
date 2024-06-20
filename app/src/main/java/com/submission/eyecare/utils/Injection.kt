package com.submission.eyecare.utils

import android.content.Context
import com.submission.eyecare.data.UserPreference
import com.submission.eyecare.data.UserRepos
import com.submission.eyecare.data.dataStore
import com.submission.eyecare.data.network.ApiConfig

object Injection {
    fun provideRepository(context: Context): UserRepos {
        val pref = UserPreference.getInstance(context.dataStore)
        val api1 = ApiConfig.getService1()
        val api2 = ApiConfig.getService2()
        return UserRepos.getInstance(pref, api1, api2)
    }
}