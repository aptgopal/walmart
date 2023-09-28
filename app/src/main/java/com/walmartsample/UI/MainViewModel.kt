package com.walmartsample.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.walmartsample.data.Country
import com.walmartsample.network.MainRepository
import com.walmartsample.network.NetworkStatus
import kotlinx.coroutines.*

class MainViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage





    val countryList = MutableLiveData<List<Country>>()

    var job: Job? = null

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

    fun getAllCountries() {
        Log.d("Thread Outside", Thread.currentThread().name)

        viewModelScope.launch {
            Log.d("Thread Inside", Thread.currentThread().name)
            when (val response = mainRepository.getAllCountries()) {
                is NetworkStatus.Success -> {
                    countryList.postValue(response.data)
                }
                is NetworkStatus.Error -> {
                    if (response.response.code() == 401) {
                        //countryList.postValue(NetworkStatus.Error())
                    } else {
                        //countryList.postValue(NetworkState.Error)
                    }
                }
            }
        }
    }

    private fun onError(message: String) {
        _errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}