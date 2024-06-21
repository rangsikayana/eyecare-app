package com.submission.eyecare.data

import androidx.lifecycle.LiveData
import com.submission.eyecare.data.local.HistoryDao
import com.submission.eyecare.data.local.HistoryData

class HistoryRepository(private val historyDao: HistoryDao) {
    val allHistory: LiveData<List<HistoryData>> = historyDao.getAllHistory()

    suspend fun insert(historyData: HistoryData) {
        historyDao.insert(historyData)
    }

    suspend fun delete(historyData: HistoryData) {
        historyDao.delete(historyData)
    }

    suspend fun clearHistory() {
        historyDao.clearHistory()
    }

}
