package com.walmartsample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.walmartsample.data.Country
import com.walmartsample.network.MainRepository
import com.walmartsample.network.NetworkStatus
import com.walmartsample.network.RetrofitService
import com.walmartsample.ui.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class MainViewModelTest {


    private val testDispatcher = TestCoroutineDispatcher()
    lateinit var mainViewModel: MainViewModel

    lateinit var mainRepository: MainRepository

    @Mock
    lateinit var apiService: RetrofitService

    @get:Rule
    val instantTaskExecutionRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)
        mainRepository = mock(MainRepository::class.java)
        mainViewModel = MainViewModel(mainRepository)
    }

    @Test
    fun getAllCountriesTest() {
        runBlocking {
            Mockito.`when`(mainRepository.getAllCountries())
                .thenReturn(NetworkStatus.Success(listOf(Country("USA", "", "US","WA"))))
            mainViewModel.getAllCountries()
            val result = mainViewModel.countryList.getOrAwaitValue()
            assertEquals(listOf(Country("USA", "", "US","WA")), result)
        }
    }


    @Test
    fun `empty country list test`() {
        runBlocking {
            Mockito.`when`(mainRepository.getAllCountries())
                .thenReturn(NetworkStatus.Success(listOf()))
            mainViewModel.getAllCountries()
            val result = mainViewModel.countryList.getOrAwaitValue()
            assertEquals(listOf<Country>(), result)
        }
    }

}