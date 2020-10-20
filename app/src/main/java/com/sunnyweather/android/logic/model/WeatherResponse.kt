package com.sunnyweather.android.logic.model

data class WeatherResponse(
    val charge: Boolean,
    val code: String,
    val msg: String,
    val result: WeatherResult
) {
    data class WeatherResult(
        val msg: String,
        val result: CityWeather,
        val status: Int
    ) {
        data class CityWeather(
            val aqi: Aqi,
            val city: String,
            val citycode: String,
            val cityid: Int,
            val daily: List<Daily>,
            val date: String,
            val hourly: List<Hourly>,
            val humidity: String,
            val img: String,
            val index: List<Index>,
            val pressure: String,
            val temp: String,
            val temphigh: String,
            val templow: String,
            val updatetime: String,
            val weather: String,
            val week: String,
            val winddirect: String,
            val windpower: String,
            val windspeed: String
        ) {
            data class Aqi(
                val aqi: String,
                val aqiinfo: Aqiinfo,
                val co: String,
                val co24: String,
                val ico: String,
                val ino2: String,
                val io3: String,
                val io38: String,
                val ipm10: String,
                val ipm2_5: String,
                val iso2: String,
                val no2: String,
                val no224: String,
                val o3: String,
                val o324: String,
                val o38: String,
                val pm10: String,
                val pm1024: String,
                val pm2_5: String,
                val pm2_524: String,
                val primarypollutant: String,
                val quality: String,
                val so2: String,
                val so224: String,
                val timepoint: String
            ) {
                data class Aqiinfo(
                    val affect: String,
                    val color: String,
                    val level: String,
                    val measure: String
                )
            }

            data class Daily(
                val date: String,
                val day: Day,
                val night: Night,
                val sunrise: String,
                val sunset: String,
                val week: String
            ) {
                data class Day(
                    val img: String,
                    val temphigh: String,
                    val weather: String,
                    val winddirect: String,
                    val windpower: String
                )

                data class Night(
                    val img: String,
                    val templow: String,
                    val weather: String,
                    val winddirect: String,
                    val windpower: String
                )
            }

            data class Hourly(
                val img: String,
                val temp: String,
                val time: String,
                val weather: String
            )

            data class Index(
                val detail: String,
                val iname: String,
                val ivalue: String
            )
        }
    }
}