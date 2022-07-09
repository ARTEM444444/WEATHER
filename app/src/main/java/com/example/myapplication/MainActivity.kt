package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewHello = findViewById<TextView>(R.id.tvHello)
        textViewHello.text = "HELLO FROM CODE"

        val btWeather = findViewById<Button>(R.id.btnWeather)
        btWeather.setOnClickListener {
            Intent(this, WeatherActivity::class.java).also (::startActivity)
        }
    }
}