package com.walmartsample.UI.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.walmartsample.data.Country
import com.walmartsample.databinding.ItemCountryBinding

class CountryAdapter(var countryList: List<Country>):
    RecyclerView.Adapter<CountryAdapter.CountryHolder>() {
    class CountryHolder(val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(get: Country) {


        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        val binding = ItemCountryBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryHolder(binding)
    }



    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        holder.bind(countryList.get(position))
    }

    override fun getItemCount(): Int {
        return countryList.size
    }
}