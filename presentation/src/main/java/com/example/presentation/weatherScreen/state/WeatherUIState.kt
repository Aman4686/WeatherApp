package com.example.feature.weatherScreen.state

import com.example.domain.model.DisplayDate
import com.example.domain.model.WeatherDomainModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

data class WeatherUIState(
    val isLoading: Boolean = false,
    val forecastDays: ImmutableList<DisplayDate>,
    val error: String? = null
){
    companion object{
        fun initial(): WeatherUIState = WeatherUIState(
            isLoading = true,
            forecastDays = emptyList<DisplayDate>().toImmutableList(),
            error = null
        )
    }
}
