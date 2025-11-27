package com.example.data.mapper

import com.example.data.model.WeatherForecastDataModel
import com.example.domain.model.DisplayDate
import com.example.domain.model.WeatherDomainModel

fun WeatherForecastDataModel.toWeatherDomainModel(): WeatherDomainModel {
    return WeatherDomainModel(
        forecastDays = forecastDays.map {
            DisplayDate(
                year = it.displayDate.year,
                month = it.displayDate.month,
                day = it.displayDate.day
            )
        }
    )
}