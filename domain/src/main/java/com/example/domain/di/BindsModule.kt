package com.example.domain.di

import com.example.domain.useCase.GetWeatherForecastUseCase
import com.example.domain.useCase.GetWeatherForecastUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindsModule {

    @Binds
    @Singleton
    abstract fun bindGetWeatherForecastUseCase(
        getWeatherForecastUseCaseImpl: GetWeatherForecastUseCaseImpl
    ): GetWeatherForecastUseCase
}