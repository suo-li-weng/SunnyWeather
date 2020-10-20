package com.sunnyweather.android.logic.model

import com.google.gson.annotations.SerializedName

class PlaceResponse(val code: String, val charge: Boolean, val msg: String, val result: CityResult)

class CityResult(val status: Int, val msg: String, @SerializedName("result") val cityList: List<City>)

class City(val cityid: Int, val parentid: Int, val citycode: String, val city: String)