package com.walmartsample.util

import com.walmartsample.data.Country

object ValidationUtil {

    fun validateCountry(country: Country) : Boolean {
        if (country.name.isNotEmpty() && country.code.isNotEmpty()&& country.capital.isNotEmpty()&& country.region.isNotEmpty()) {
            return true
        }
        return false
    }
}