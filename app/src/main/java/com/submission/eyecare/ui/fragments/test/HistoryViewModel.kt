package com.submission.eyecare.ui.fragments.test

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.submission.eyecare.data.HistoryRepository
import com.submission.eyecare.data.local.HistoryData
import com.submission.eyecare.data.local.HistoryDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HistoryViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: HistoryRepository
    val allHistory: LiveData<List<HistoryData>>

    init {
        val historyDao = HistoryDatabase.getDatabase(application).historyDao()
        repository = HistoryRepository(historyDao)
        allHistory = repository.allHistory
    }

    fun insert(historyData: HistoryData) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(historyData)
    }

    fun delete(historyData: HistoryData) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(historyData)
    }
    fun clearHistory() = viewModelScope.launch(Dispatchers.IO) {
        repository.clearHistory()
    }

}
