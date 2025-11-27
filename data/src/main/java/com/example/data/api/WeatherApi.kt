package com.example.data.api

import com.example.data.model.WeatherForecastDataModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast/days:lookup")
    suspend fun getWeatherForecast(@Query("location.latitude") latitude: Double,
                           @Query("location.longitude") longitude: Double): Response<WeatherForecastDataModel>

}