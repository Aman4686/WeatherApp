package com.example.data.api.utils

import com.example.domain.model.NetworkResult
import retrofit2.HttpException
import retrofit2.Response

suspend fun <T : Any> handleApi(
    execute: suspend () -> Response<T>
): NetworkResult<T> {
    return try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            NetworkResult.Success(body)
        } else {
            NetworkResult.Error(code = response.code(), message = response.message())
        }
    } catch (e: HttpException) {
        NetworkResult.Error(code = e.code(), message = e.message())
    } catch (e: Throwable) {
        NetworkResult.Exception(e)
    }
}

inline fun <T : Any, R : Any> NetworkResult<T>.map(
    transform: (T) -> R
): NetworkResult<R> {
    return when (this) {
        is NetworkResult.Error -> NetworkResult.Error(code, message)
        is NetworkResult.Exception -> NetworkResult.Exception(e)
        is NetworkResult.Success -> NetworkResult.Success(transform(data))
    }
}