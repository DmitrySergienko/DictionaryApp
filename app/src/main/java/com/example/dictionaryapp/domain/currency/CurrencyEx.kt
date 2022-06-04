package com.example.dictionaryapp.domain.currency


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CurrencyEx(
    @SerializedName("amount")
    val amount: Int,
    @SerializedName("base")
    val base: String,
    @SerializedName("converted")
    val converted: Double,
    @SerializedName("lastUpdate")
    val lastUpdate: Int,
    @SerializedName("rate")
    val rate: Double,
    @SerializedName("to")
    val to: String
)