package com.submission.eyecare.data.dummy

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HistoryData(
    val img: Int,
    val category: String,
    val percent: String,
) : Parcelable
