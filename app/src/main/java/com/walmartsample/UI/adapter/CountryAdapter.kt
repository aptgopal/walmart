package com.walmartsample.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.walmartsample.data.Country
import com.walmartsample.databinding.ItemCountryBinding
import com.walmartsample.util.ValidationUtil

class CountryAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var countryList = mutableListOf<Country>()

    fun setCountries(countries: List<Country>) {
        this.countryList = countries.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCountryBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val country = countryList[position]
        if (ValidationUtil.validateCountry(country)) {
            holder.binding.countryName.text = country.name
            holder.binding.countryRegion.text = country.region
            holder.binding.countryCode.text = country.code
            holder.binding.capital.text = country.capital
        }
    }

    override fun getItemCount(): Int {
        return countryList.size
    }
}

class MainViewHolder(val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root) {

}