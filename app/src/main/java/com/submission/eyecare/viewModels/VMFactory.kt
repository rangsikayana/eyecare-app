package com.submission.eyecare.viewModels

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.submission.eyecare.data.UserRepos
import com.submission.eyecare.utils.Injection

class VMFactory private constructor(private val repo: UserRepos) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(repo) as T
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