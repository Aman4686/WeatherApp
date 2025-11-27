package com.example.data.repository

import com.example.data.api.WeatherApi
import com.example.data.api.utils.handleApi
import com.example.data.api.utils.map
import com.example.data.mapper.toWeatherDomainModel
import com.example.domain.di.IoDispatcher
import com.example.domain.model.NetworkResult
import com.example.domain.model.WeatherDomainModel
import com.example.domain.repository.WeatherRepository
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : WeatherRepository{
    override suspend fun getWeatherForecast(): NetworkResult<WeatherDomainModel> {
        return withContext(ioDispatcher){
            val result = handleApi { weatherApi.getWeatherForecast(latitude = 52.22849, longitude = 20.96648) }
           result.map { it.toWeatherDomainModel() }
        }
    }
}