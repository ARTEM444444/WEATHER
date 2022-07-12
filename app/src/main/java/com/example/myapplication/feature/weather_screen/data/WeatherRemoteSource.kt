package com.example.myapplication.feature.weather_screen.data

import retrofit2.Response

class WeatherRemoteSource(private val api: WeatherApi) {

    // TODO add queri
    fun getWeather(): Response<String> {
return api.getWeather("Moscow")
    }
}