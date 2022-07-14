package com.example.myapplication.feature.weather_screen.data

interface WeatherRepo {

  suspend  fun getTemperature(): String

}