package com.example.exchangerate.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ValuteInfo(
    @SerializedName("ID")
    @Expose
    val id : String? = null ,

    @SerializedName("NumCode")
    @Expose
    val numCode : String? = null ,

    @SerializedName("CharCode")
    @Expose
    val charCode : String? = null ,

    @SerializedName("Nominal")
    @Expose
    val nominal : Long? = null ,

    @SerializedName("Name")
    @Expose
    val name : String? = null ,

    @SerializedName("Value")
    @Expose
    val value : Double? = null ,

    @SerializedName("Previous")
    @Expose
    val previous : Double? = null
)