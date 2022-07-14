package com.example.myapplication.feature.weather_screen.ui

import com.example.myapplication.feature.weather_screen.WeatherInteractor

class WeatherScreenPresenter(val interactor: WeatherInteractor) {

    suspend fun getWeather(): String{
        return interactor.getWeather()
    }
}