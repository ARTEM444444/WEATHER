package com.example.myapplication.feature.weather_screen.data.model

import com.google.gson.annotations.SerializedName

data class WeatherRemoteModel(
@SerializedName("main")
val main: WeatherMainRemoteModel
)
