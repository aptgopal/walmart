package com.walmartsample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.walmartsample.databinding.ActivityCountryBinding
import com.walmartsample.network.MainRepository
import com.walmartsample.network.RetrofitService
import com.walmartsample.ui.MainViewModel
import com.walmartsample.ui.adapter.CountryAdapter
import com.walmartsample.ui.adapter.MyViewModelFactory

class CountryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCountryBinding
    private val adapter= CountryAdapter()
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCountryBinding.inflate(layoutInflater)
        val view=binding.root

        setContentView(view)
        val retrofitService = RetrofitService.getInstance()
        val mainRepository = MainRepository(retrofitService)
        binding.countryList.layoutManager=LinearLayoutManager(this)
        binding.countryList.adapter = adapter

        viewModel = ViewModelProvider(this, MyViewModelFactory(mainRepository)).get(MainViewModel::class.java)


        viewModel.countryList.observe(this) {
            adapter.setCountries(it)
        }

        viewModel.errorMessage.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.loading.observe(this, Observer {
            if (it) {
               // binding.progressDialog.visibility = View.VISIBLE
            } else {
                //binding.progressDialog.visibility = View.GONE
            }
        })

        viewModel.getAllCountries()
    }

}


