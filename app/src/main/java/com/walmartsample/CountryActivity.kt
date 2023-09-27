package com.walmartsample

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.walmartsample.UI.adapter.CountryAdapter
import com.walmartsample.data.Country
import com.walmartsample.databinding.ActivityCountryBinding

class CountryActivity : Activity() {
    private lateinit var binding: ActivityCountryBinding
    private lateinit var adapter: CountryAdapter
    private lateinit var countryList :List<Country>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCountryBinding.inflate(layoutInflater)
        val view=binding.root

        setContentView(view)
        countryList();
        binding.countryList.layoutManager= LinearLayoutManager(this)
        adapter= CountryAdapter(countryList)
        binding.countryList.adapter=adapter
    }

    private fun countryList(){
        countryList= listOf(Country("Test","Test","Test","Test"), Country("Test","Test","Test","Test"),
                Country("Test","Test","Test","Test"),
        Country("Test","Test","Test","Test"),
        Country("Test","Test","Test","Test"))
    }
}


