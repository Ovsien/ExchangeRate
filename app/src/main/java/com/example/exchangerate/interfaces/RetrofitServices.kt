package com.example.exchangerate.interfaces

import com.example.exchangerate.models.ExchangeRateInfo
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {
    @GET("daily_json.js")
    fun getExchangeRate(): Call<ExchangeRateInfo>
}