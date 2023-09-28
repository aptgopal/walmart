package com.walmartsample

import com.walmartsample.data.Country
import com.walmartsample.util.ValidationUtil
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidationUtilTest {

    @Test
    fun validateCountryTest() {
        val country = Country("USA","US","Us","Wasington")
        assertEquals(true, ValidationUtil.validateCountry(country))
    }

    @Test
    fun validateCountryEmptyTest() {
        val country = Country("","US","Us","Wasington")
        assertEquals(false, ValidationUtil.validateCountry(country))
    }

}