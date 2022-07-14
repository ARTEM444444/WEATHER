package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.feature.weather_screen.WeatherInteractor
import com.example.myapplication.feature.weather_screen.data.WeatherApiClient
import com.example.myapplication.feature.weather_screen.data.WeatherRemoteSource
import com.example.myapplication.feature.weather_screen.data.WeatherRepo
import com.example.myapplication.feature.weather_screen.data.WetherRepolmpl
import com.example.myapplication.feature.weather_screen.ui.WeatherScreenPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: WeatherScreenPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = WeatherScreenPresenter(
            WeatherInteractor(
                WetherRepolmpl(
                    WeatherRemoteSource(
                        WeatherApiClient.getApi()
                    ))
            ))

        var weather = ""
        val textViewHello = findViewById<TextView>(R.id.tvHello)

        GlobalScope.launch {
          withContext(Dispatchers.Main) {
              textViewHello.text = presenter.getWeather()
          }
        }




        val btWeather = findViewById<Button>(R.id.btnWeather)
        btWeather.setOnClickListener {
            Intent(this, WeatherActivity::class.java).also (::startActivity)
        }


         
    }
}