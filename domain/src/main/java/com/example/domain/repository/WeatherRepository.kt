package com.example.domain.repository

import com.example.domain.model.NetworkResult
import com.example.domain.model.WeatherDomainModel

interface WeatherRepository {

    suspend fun getWeatherForecast(): NetworkResult<WeatherDomainModel>
}