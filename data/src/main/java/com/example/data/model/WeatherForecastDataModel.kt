package com.example.data.model

import com.google.gson.annotations.SerializedName

data class WeatherForecastDataModel(
    @SerializedName("forecastDays")
    val forecastDays: List<ForecastDay>,

    @SerializedName("timeZone")
    val timeZone: TimeZoneInfo
)

data class ForecastDay(
    @SerializedName("interval")
    val interval: Interval,

    @SerializedName("displayDate")
    val displayDate: DisplayDate,

    @SerializedName("daytimeForecast")
    val daytimeForecast: ForecastPart?,

    @SerializedName("nighttimeForecast")
    val nighttimeForecast: ForecastPart?,

    @SerializedName("maxTemperature")
    val maxTemperature: Temperature?,

    @SerializedName("minTemperature")
    val minTemperature: Temperature?,

    @SerializedName("feelsLikeMaxTemperature")
    val feelsLikeMaxTemperature: Temperature?,

    @SerializedName("feelsLikeMinTemperature")
    val feelsLikeMinTemperature: Temperature?,

    @SerializedName("sunEvents")
    val sunEvents: SunEvents?,

    @SerializedName("moonEvents")
    val moonEvents: MoonEvents?,

    @SerializedName("maxHeatIndex")
    val maxHeatIndex: Temperature?,

    @SerializedName("iceThickness")
    val iceThickness: IceThickness?
)

data class Interval(
    @SerializedName("startTime")
    val startTime: String,

    @SerializedName("endTime")
    val endTime: String
)

data class DisplayDate(
    @SerializedName("year")
    val year: Int,

    @SerializedName("month")
    val month: Int,

    @SerializedName("day")
    val day: Int
)

/**
 * Used for both daytimeForecast and nighttimeForecast
 */
data class ForecastPart(
    @SerializedName("interval")
    val interval: Interval,

    @SerializedName("weatherCondition")
    val weatherCondition: WeatherCondition,

    @SerializedName("relativeHumidity")
    val relativeHumidity: Int,

    @SerializedName("uvIndex")
    val uvIndex: Int,

    @SerializedName("precipitation")
    val precipitation: Precipitation,

    @SerializedName("thunderstormProbability")
    val thunderstormProbability: Int,

    @SerializedName("wind")
    val wind: Wind,

    @SerializedName("cloudCover")
    val cloudCover: Int
)

data class WeatherCondition(
    @SerializedName("iconBaseUri")
    val iconBaseUri: String,

    @SerializedName("description")
    val description: WeatherDescription,

    @SerializedName("type")
    val type: String
)

data class WeatherDescription(
    @SerializedName("text")
    val text: String,

    @SerializedName("languageCode")
    val languageCode: String
)

data class Precipitation(
    @SerializedName("probability")
    val probability: PrecipitationProbability,

    @SerializedName("qpf")
    val qpf: Qpf
)

data class PrecipitationProbability(
    @SerializedName("percent")
    val percent: Int,

    @SerializedName("type")
    val type: String
)

data class Qpf(
    @SerializedName("quantity")
    val quantity: Double,

    @SerializedName("unit")
    val unit: String
)

data class Wind(
    @SerializedName("direction")
    val direction: WindDirection,

    @SerializedName("speed")
    val speed: WindSpeed,

    @SerializedName("gust")
    val gust: WindSpeed
)

data class WindDirection(
    @SerializedName("degrees")
    val degrees: Int,

    @SerializedName("cardinal")
    val cardinal: String
)

data class WindSpeed(
    @SerializedName("value")
    val value: Double,

    @SerializedName("unit")
    val unit: String
)

data class Temperature(
    @SerializedName("degrees")
    val degrees: Double,

    @SerializedName("unit")
    val unit: String
)

data class SunEvents(
    @SerializedName("sunriseTime")
    val sunriseTime: String,

    @SerializedName("sunsetTime")
    val sunsetTime: String
)

data class MoonEvents(
    @SerializedName("moonPhase")
    val moonPhase: String,

    @SerializedName("moonriseTimes")
    val moonriseTimes: List<String>,

    @SerializedName("moonsetTimes")
    val moonsetTimes: List<String>
)

data class IceThickness(
    @SerializedName("thickness")
    val thickness: Double,

    @SerializedName("unit")
    val unit: String
)

data class TimeZoneInfo(
    @SerializedName("id")
    val id: String
)
