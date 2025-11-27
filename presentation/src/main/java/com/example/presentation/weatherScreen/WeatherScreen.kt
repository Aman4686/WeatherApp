package com.example.feature.weather.weatherScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.feature.weatherScreen.state.WeatherUIState
import com.example.presentation.weatherScreen.WeatherViewModel


@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel(),
) {

    val state = viewModel.state.collectAsStateWithLifecycle()

    WeatherScreenView(state.value)
}

@Composable
fun WeatherScreenView(state: WeatherUIState){
    Column(Modifier.fillMaxSize()) {
        LazyColumn {
            items(items = state.forecastDays, key = { it.hashCode() }) { forecastDay ->
                Text(text = forecastDay.toString(), fontSize = 32.sp)
                Spacer(Modifier.size(height = 10.dp, width = 0.dp))
            }
        }
    }
}