package com.submission.eyecare.data.local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Diseases(
    val name: String,
    val desc: String,
    val pic: String
) : Parcelable
