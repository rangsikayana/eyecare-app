package com.submission.eyecare.data.local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BaseKnowledge(
    val category: String,
    val food: String,
    val vitamin: String,
    val eyeTreatment: String,
) : Parcelable
