package com.submission.eyecare.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class IshiharaPlate(
    val imageResId: Int,
    val correctAnswer: String
) : Parcelable
