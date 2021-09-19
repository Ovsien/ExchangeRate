package com.example.exchangerate.services

import com.example.exchangerate.interfaces.RetrofitServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit: Retrofit? = null

    private const val BASE_URL = "https://www.cbr-xml-daily.ru/"

    fun getClient(): RetrofitServices {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(RetrofitServices::class.java)
    }
}