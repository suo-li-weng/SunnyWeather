package com.sunnyweather.android.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sunnyweather.android.SunnyWeatherApplication
import com.sunnyweather.android.logic.model.City
import java.lang.reflect.Type
import kotlin.reflect.typeOf

object PlaceDao {

    fun savePlace(city: City) {
        sharedPreferences().edit {
            putString("city", Gson().toJson(city))
        }
    }

    fun getSavedPlace(): City {
        val placeJson = sharedPreferences().getString("city", "")
        return Gson().fromJson(placeJson, City::class.java)
    }

    fun isPlaceSaved() = sharedPreferences().contains("city")

    fun savePlaces(cityList: List<City>) {
        sharedPreferences().edit {
            putString("cityList", Gson().toJson(cityList))
        }
    }

    fun getSavedPlaces(): List<City> {
        val placeJson = sharedPreferences().getString("cityList", "")
        val typeOf = object : TypeToken<List<City>>() {}.type
        return Gson().fromJson(placeJson, typeOf)
    }

    fun isPlacesSaved() = sharedPreferences().contains("cityList")


    private fun sharedPreferences() =
        SunnyWeatherApplication.context.getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)

}