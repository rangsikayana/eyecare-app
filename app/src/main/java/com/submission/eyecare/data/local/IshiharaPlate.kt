package com.submission.eyecare.data.local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class IshiharaPlate(
    val imageResId: Int,
    val correctAnswer: String
) : Parcelable