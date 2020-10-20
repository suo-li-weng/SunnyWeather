package com.sunnyweather.android.logic.network

import com.sunnyweather.android.SunnyWeatherApplication
import com.sunnyweather.android.logic.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather?appkey=${SunnyWeatherApplication.TOKEN}")
    fun getWeather(@Query("city") city: String): Call<WeatherResponse>
}