package com.example.domain.useCase

import com.example.domain.di.DefaultDispatcher
import com.example.domain.model.NetworkResult
import com.example.domain.model.WeatherDomainModel
import com.example.domain.repository.WeatherRepository
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

interface GetWeatherForecastUseCase{
    suspend operator fun invoke(): NetworkResult<WeatherDomainModel>
}

class GetWeatherForecastUseCaseImpl @Inject constructor(
    private val weatherRepository: WeatherRepository,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
) : GetWeatherForecastUseCase{

    override suspend operator fun invoke(): NetworkResult<WeatherDomainModel>{
        return withContext(defaultDispatcher){
            weatherRepository.getWeatherForecast()
        }
    }
}