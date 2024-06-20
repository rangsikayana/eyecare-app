package com.submission.eyecare.ui.fragments.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.submission.eyecare.data.UserRepos
import com.submission.eyecare.data.local.UserDisplayName
import kotlinx.coroutines.launch

class NotificationsViewModel(private val repo: UserRepos) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

    fun getTheme(): LiveData<Boolean> {
        return repo.getTheme().asLiveData()
    }

    fun logout() {
        viewModelScope.launch {
            repo.logout()
        }
    }

    fun saveTheme(isDark: Boolean) {
        viewModelScope.launch {
            repo.saveTheme(isDark)
        }
    }
    fun fetchName(): LiveData<UserDisplayName> {
        return repo.getName().asLiveData()
    }
}