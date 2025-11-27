package com.example.domain.model

data class WeatherDomainModel(
    val forecastDays: List<DisplayDate>,
)

data class DisplayDate(
    val year: Int,
    val month: Int,
    val day: Int
)