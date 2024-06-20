package com.submission.eyecare.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.submission.eyecare.data.UserRepos
import com.submission.eyecare.ui.auth.login.LoginViewModel
import com.submission.eyecare.ui.auth.register.RegisterViewModel
import com.submission.eyecare.ui.colorBlindTest.PlateViewModel
import com.submission.eyecare.ui.fragments.home.HomeViewModel
import com.submission.eyecare.ui.fragments.notifications.NotificationsViewModel
import com.submission.eyecare.ui.scan.ScanViewModel
import com.submission.eyecare.ui.splash.SplashViewModel
import com.submission.eyecare.utils.Injection

class VMFactory private constructor(private val repo: UserRepos) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repo) as T
        } else if (modelClass.isAssignableFrom(SplashViewModel::class.java)) {
            return SplashViewModel(repo) as T
        } else if (modelClass.isAssignableFrom(NotificationsViewModel::class.java)) {
            return NotificationsViewModel(repo) as T
        } else if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(repo) as T
        } else if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(repo) as T
        } else if (modelClass.isAssignableFrom(ScanViewModel::class.java)){
            return ScanViewModel(repo) as T
        } else if (modelClass.isAssignableFrom(PlateViewModel::class.java)) {
            return PlateViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
    companion object {
        @Volatile
        private var INSTANCE: VMFactory? = null
        @JvmStatic
        fun getInstance(context: Context): VMFactory {
            if (INSTANCE == null) {
                synchronized(VMFactory::class.java) {
                    INSTANCE = VMFactory(Injection.provideRepository(context))
                }
            }
            return INSTANCE as VMFactory
        }
    }
}