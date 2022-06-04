package com.example.dictionaryapp.domain.exchange


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Info(
    @SerializedName("rate")
    val rate: Double,
    @SerializedName("timestamp")
    val timestamp: Int
)