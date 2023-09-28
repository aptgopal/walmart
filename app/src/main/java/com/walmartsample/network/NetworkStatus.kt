package com.walmartsample.network

import retrofit2.Response

sealed class NetworkStatus<out T> {
    data class Success<out T>(val data: T): NetworkStatus<T>()
    data class Error<T>(val response: Response<T>): NetworkStatus<T>()
}

fun <T> Response<T>.parseResponse(): NetworkStatus<T> {
    return if (this.isSuccessful && this.body() != null) {
        val responseBody = this.body()
        NetworkStatus.Success(responseBody!!)
    } else {
        NetworkStatus.Error(this)
    }
}