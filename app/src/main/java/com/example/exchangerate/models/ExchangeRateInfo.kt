package com.example.exchangerate.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ExchangeRateInfo(
    @SerializedName("Date")
    @Expose
    val date: String? = null,

    @SerializedName("PreviousDate")
    @Expose
    val previousDate: String? = null,

    @SerializedName("PreviousURL")
    @Expose
    val previousURL: String? = null,

    @SerializedName("Timestamp")
    @Expose
    val timestamp: String? = null,

    @SerializedName("Valute")
    @Expose
    var valuteInfo: Map<String, ValuteInfo>? = null
)