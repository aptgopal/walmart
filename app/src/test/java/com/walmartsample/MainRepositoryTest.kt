package com.walmartsample

import com.walmartsample.data.Country
import com.walmartsample.network.MainRepository
import com.walmartsample.network.NetworkStatus
import com.walmartsample.network.RetrofitService
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

@RunWith(JUnit4::class)
class MainRepositoryTest {

    lateinit var mainRepository: MainRepository

    @Mock
    lateinit var apiService: RetrofitService

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        mainRepository = MainRepository(apiService)
    }

    @Test
    fun `get all countries test`() {
        runBlocking {
            Mockito.`when`(apiService.getAllCountries()).thenReturn(Response.success(listOf<Country>()))
            val response = mainRepository.getAllCountries()
            assertEquals(listOf<Country>(),  NetworkStatus.Success(response).data)
        }

    }

}