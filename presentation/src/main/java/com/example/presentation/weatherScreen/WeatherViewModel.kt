package com.example.presentation.weatherScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.NetworkResult
import com.example.domain.useCase.GetWeatherForecastUseCase
import com.example.feature.weatherScreen.state.WeatherUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class WeatherViewModel @Inject constructor(
    val getWeatherForecastUseCase: GetWeatherForecastUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<WeatherUIState> = MutableStateFlow(WeatherUIState.initial())
    val state: StateFlow<WeatherUIState> by lazy {
        _state.onStart {
            viewModelScope.launch {
                initData()    
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = WeatherUIState.initial()
        )
    }
    
    suspend fun initData(){
        val result = getWeatherForecastUseCase()
        when(result){
            is NetworkResult.Success -> {
                _state.update {
                    it.copy(
                        forecastDays = result.data.forecastDays.toImmutableList(),
                        isLoading = false
                    )
                }
            }
            is NetworkResult.Error -> {
                Log.d("WeatherViewModel", "Error: ${result.message} ${result.code}")
            }
            is NetworkResult.Exception -> {
                Log.d("WeatherViewModel", "Exception: ${result.e.message}")
            }
            else -> {}
        }
    }
}