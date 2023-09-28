package com.walmartsample.network

import com.walmartsample.data.Country

class MainRepository constructor(private val retrofitService: RetrofitService) {

    suspend fun getAllCountries() : NetworkStatus<List<Country>> {
            val response = retrofitService.getAllCountries()
            return if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null) {
                    NetworkStatus.Success(responseBody)
                } else {
                    NetworkStatus.Error(response)
                }
            } else {
                NetworkStatus.Error(response)
            }
        }

}