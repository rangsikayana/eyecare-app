package com.submission.eyecare.data.local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Medications(
    val url: String,
    val name: String,
    val overview: String,
    val about: String
): Parcelable
