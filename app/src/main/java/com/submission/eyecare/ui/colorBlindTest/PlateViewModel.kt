package com.submission.eyecare.ui.colorBlindTest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.submission.eyecare.data.IshiharaPlate
import com.submission.eyecare.data.UserRepos

class PlateViewModel(private val repo: UserRepos): ViewModel() {
    private val _plates = MutableLiveData<List<IshiharaPlate>>()
    val plates: LiveData<List<IshiharaPlate>> get() = _plates

    init {
        loadPlates()
    }

    private fun loadPlates() {
        _plates.value = repo.getPlates()
    }
}
