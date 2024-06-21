package com.submission.eyecare.data.dummy

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "history_table")
data class HistoryData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "img") val img: String,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "percent") val percent: String,
) : Parcelable
