package com.sunnyweather.android.ui.weather

import androidx.lifecycle.*
import com.sunnyweather.android.logic.Repository

import com.sunnyweather.android.logic.model.CityLittle

class WeatherViewModel : ViewModel() {

    private val locationLiveData = MutableLiveData<CityLittle>()

    var cityid = 1

    var placeName = ""

    val weatherLiveData = Transformations.switchMap(locationLiveData) { location ->
        Repository.refreshWeather(placeName)
    }

    fun refreshWeather(cityid: Int) {
        locationLiveData.value = CityLittle(cityid)
    }

}