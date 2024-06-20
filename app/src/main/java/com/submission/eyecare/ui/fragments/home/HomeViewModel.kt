package com.submission.eyecare.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.submission.eyecare.data.UserRepos
import com.submission.eyecare.data.local.UserDisplayName

class HomeViewModel(private val repo: UserRepos) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "User"
    }
    val text: LiveData<String> = _text

   fun fetchName(): LiveData<UserDisplayName> {
       return repo.getName().asLiveData()
   }

}