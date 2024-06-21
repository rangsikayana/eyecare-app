package com.submission.eyecare.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HistoryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(historyData: HistoryData)

    @Query("SELECT * FROM history_table ORDER BY id DESC")
    fun getAllHistory(): LiveData<List<HistoryData>>

    @Delete
    suspend fun delete(historyData: HistoryData)

    @Query("DELETE FROM history_table")
    suspend fun clearHistory()

}
