package com.example.myapplication.feature.weather_screen.di

import com.example.myapplication.BASE_URL
import com.example.myapplication.feature.weather_screen.WeatherInteractor
import com.example.myapplication.feature.weather_screen.data.*
import com.example.myapplication.feature.weather_screen.ui.WeatherScreenViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val weatherScreenModule = module {

   // presenter = WeatherScreenPresenter(
   //     WeatherInteractor(
    //        WetherRepolmpl(
     //           WeatherRemoteSource(
    //                WeatherApiClient.getApi()
      //          ) )))

    single<OkHttpClient> {  OkHttpClient.Builder().build()}

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }

    single<WeatherApi> {
        get<Retrofit>().create(WeatherApi::class.java) }

    single { WeatherRemoteSource(get<WeatherApi>()) }

     single<WeatherRepo> {WetherRepolmpl(get<WeatherRemoteSource>())}

    single { WeatherInteractor(get<WeatherRepo>())}

    viewModel { WeatherScreenViewModel(get<WeatherInteractor>()) }
}