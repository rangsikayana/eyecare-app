package com.submission.eyecare.data.network.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PredictResponse(
	@SerializedName("confidence") val confidence: Float,
	@SerializedName("predicted_class") val predictedClass: String
)

data class Error (
	@SerializedName("error") val error: String
)
