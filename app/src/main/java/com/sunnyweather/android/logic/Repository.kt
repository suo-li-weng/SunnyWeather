package com.sunnyweather.android.logic

import androidx.lifecycle.liveData
import com.sunnyweather.android.logic.dao.PlaceDao
import com.sunnyweather.android.logic.model.City
import com.sunnyweather.android.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.CoroutineContext

object Repository {

    fun searchPlaces(query: String) = fire(Dispatchers.IO) {
        var places: List<City>? = null
        var errorMsg: String? = null

        val search = query.trim()
        if (isPlacesSaved()) {
            places = getSavedPlaces()
        } else {
            val placeResponse = SunnyWeatherNetwork.searchPlaces()
            if (placeResponse.code == "10000") {
                places = placeResponse.result.cityList
                savePlaces(places)
            } else {
                errorMsg = placeResponse.msg
            }
        }

        if (places != null) {
            if (search.isNotEmpty()) {
                var res = ArrayList<City>()
                for (city in places) {
                    if (city.city.contains(search)) {
                        res.add(city)
                    }
                }
                Result.success(res)
            } else {
                Result.success(places)
            }

        } else {
            Result.failure(
                RuntimeException(
                    "some errors have occurred: ${errorMsg}"
                )
            )
        }
    }

    fun refreshWeather(city: String) = fire(Dispatchers.IO) {
        coroutineScope {
            val deferredWeather = async {
                SunnyWeatherNetwork.getWeather(city)
            }

            val realtimeResponse = deferredWeather.await()

            if (realtimeResponse.code == "10000") {
                Result.success(realtimeResponse.result.result)
            } else {
                Result.failure(
                    RuntimeException(
                        "realtime response status is ${realtimeResponse.msg}"
                    )
                )
            }
        }
    }

    fun savePlace(city: City) = PlaceDao.savePlace(city)

    fun getSavedPlace() = PlaceDao.getSavedPlace()

    fun isPlaceSaved() = PlaceDao.isPlaceSaved()

    fun savePlaces(citylist: List<City>) = PlaceDao.savePlaces(citylist)

    fun getSavedPlaces() = PlaceDao.getSavedPlaces()

    fun isPlacesSaved() = PlaceDao.isPlacesSaved()

    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
        liveData<Result<T>>(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure<T>(e)
            }
            emit(result)
        }

}