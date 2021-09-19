package com.example.exchangerate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.exchangerate.adapters.ExchangeRateAdapter
import com.example.exchangerate.interfaces.RetrofitServices
import com.example.exchangerate.models.ExchangeRateInfo
import com.example.exchangerate.models.ValuteInfo
import com.example.exchangerate.services.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var exchangeRate : ExchangeRateInfo? = null

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        getExchange()
    }

    private fun getExchange() : ExchangeRateInfo? {
        val retrofitServices : RetrofitServices = RetrofitClient.getClient()
        val call : Call<ExchangeRateInfo> = retrofitServices.getExchangeRate()

        call.enqueue(object : Callback<ExchangeRateInfo> {
            override fun onResponse(
                call : Call<ExchangeRateInfo> ,
                response : Response<ExchangeRateInfo>
            ) {
                val exchangeRateInfo : ExchangeRateInfo? = response.body()

                if (exchangeRateInfo?.valuteInfo == null) return

                exchangeRate = exchangeRateInfo

                init()

                //#Strar test part
                val map = exchangeRate?.valuteInfo

                map?.forEach { valute ->
                    Log.d(
                        "Result: " ,
                        valute.key + " " + valute.value.name + " " + valute.value.value
                    )
                }
                ////#End test part
            }

            override fun onFailure(call : Call<ExchangeRateInfo> , t : Throwable) {
            }
        })

        return exchangeRate
    }

    private fun mapToList(map : Map<String , ValuteInfo>) : ArrayList<ValuteInfo> {
        val valuteList : ArrayList<ValuteInfo> = ArrayList()

        map.forEach { valute ->
            valuteList.add(valute.value)
        }

        return valuteList
    }

    private fun init() {
        val valuteList = exchangeRate?.valuteInfo
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView_main)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView.adapter = ExchangeRateAdapter(mapToList(valuteList !!))
    }
}