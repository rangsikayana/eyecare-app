package com.submission.eyecare.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "User"
    }
    val text: LiveData<String> = _text

   /* fun getTheme(): LiveData<Boolean> {
        return repo.getTheme().asLiveData()
    }*/

}