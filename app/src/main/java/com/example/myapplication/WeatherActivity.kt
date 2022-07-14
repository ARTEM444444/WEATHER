package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.feature.weather_screen.WindActivity

class WeatherActivity : AppCompatActivity(){

    private val weatherPresenter = WeatherPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val tvTemperature = findViewById<TextView>(R.id.tvTemperature)
        tvTemperature.text = weatherPresenter.getWeather()

        val btWind = findViewById<Button>(R.id.btnWind)
        btWind.setOnClickListener {
            Intent(this, WindActivity::class.java).also (::startActivity)
        }
    }
}