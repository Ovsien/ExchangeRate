package com.example.exchangerate.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exchangerate.R
import com.example.exchangerate.databinding.ValuteItemBinding
import com.example.exchangerate.models.ValuteInfo

class ExchangeRateAdapter(private val valuteList : ArrayList<ValuteInfo>) :
    RecyclerView.Adapter<ExchangeRateAdapter.ExchangeRateHolder>() {

    override fun onCreateViewHolder(p0 : ViewGroup , p1 : Int) : ExchangeRateHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.valute_item , p0 , false)

        return ExchangeRateHolder(view)
    }

    override fun onBindViewHolder(holder : ExchangeRateHolder , position : Int) {
        holder.bind(valuteList[position])
    }

    override fun getItemCount() : Int {
        return valuteList.size
    }

    class ExchangeRateHolder(item : View) : RecyclerView.ViewHolder(item) {
        private val binding = ValuteItemBinding.bind(item)

        fun bind(valuteInfo : ValuteInfo) = with(binding) {
            valuteName.text = valuteInfo.name
            charCode.text = ("(${valuteInfo.charCode})")
            value.text = valuteInfo.value.toString()
            previous.text = valuteInfo.previous.toString()
        }
    }
}