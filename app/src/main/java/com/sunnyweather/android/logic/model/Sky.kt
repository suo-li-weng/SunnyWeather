package com.sunnyweather.android.logic.model

import com.sunnyweather.android.R

class Sky (val info: String, val icon: Int, val bg: Int)

private val sky = mapOf(
    "0" to Sky("晴", R.drawable.ic_0, R.drawable.bg_clear_day),
    "999" to Sky("晴", R.drawable.ic_clear_night, R.drawable.bg_clear_night),
    "1" to Sky("多云", R.drawable.ic_1, R.drawable.bg_partly_cloudy_day),
    "998" to Sky("多云", R.drawable.ic_partly_cloud_night, R.drawable.bg_partly_cloudy_night),
    "2" to Sky("阴", R.drawable.ic_2, R.drawable.bg_cloudy),
    "WIND" to Sky("大风", R.drawable.ic_cloudy, R.drawable.bg_wind),
    "3" to Sky("阵雨", R.drawable.ic_3, R.drawable.bg_rain),
    "4" to Sky("雷阵雨", R.drawable.ic_4, R.drawable.bg_rain),
    "5" to Sky("雷阵雨伴有冰雹", R.drawable.ic_5, R.drawable.bg_rain),
    "6" to Sky("雨夹雪", R.drawable.ic_6, R.drawable.bg_rain),
    "7" to Sky("小雨", R.drawable.ic_7, R.drawable.bg_rain),
    "8" to Sky("中雨", R.drawable.ic_8, R.drawable.bg_rain),
    "9" to Sky("大雨", R.drawable.ic_9, R.drawable.bg_rain),
    "10" to Sky("暴雨", R.drawable.ic_10, R.drawable.bg_rain),
    "11" to Sky("大暴雨", R.drawable.ic_11, R.drawable.bg_rain),
    "12" to Sky("特大暴雨", R.drawable.ic_12, R.drawable.bg_rain),
    "13" to Sky("阵雪", R.drawable.ic_13, R.drawable.bg_snow),
    "14" to Sky("小雪", R.drawable.ic_14, R.drawable.bg_snow),
    "15" to Sky("中雪", R.drawable.ic_15, R.drawable.bg_snow),
    "16" to Sky("大雪", R.drawable.ic_16, R.drawable.bg_snow),
    "17" to Sky("暴雪", R.drawable.ic_17, R.drawable.bg_snow),
    "18" to Sky("雾", R.drawable.ic_18, R.drawable.bg_fog),
    "19" to Sky("冻雨", R.drawable.ic_19, R.drawable.bg_fog),
    "HAIL" to Sky("冰雹", R.drawable.ic_hail, R.drawable.bg_snow),
    "20" to Sky("沙尘暴", R.drawable.ic_20, R.drawable.bg_fog),
    "21" to Sky("小雨-中雨", R.drawable.ic_21, R.drawable.bg_rain),
    "22" to Sky("中雨-大雨", R.drawable.ic_22, R.drawable.bg_rain),
    "23" to Sky("大雨-暴雨", R.drawable.ic_23, R.drawable.bg_rain),
    "24" to Sky("暴雨-大暴雨", R.drawable.ic_24, R.drawable.bg_rain),
    "25" to Sky("大暴雨-特大暴雨", R.drawable.ic_25, R.drawable.bg_rain),
    "26" to Sky("小雪-中雪", R.drawable.ic_26, R.drawable.bg_snow),
    "27" to Sky("中雪-大雪", R.drawable.ic_27, R.drawable.bg_snow),
    "28" to Sky("大雪-暴雪", R.drawable.ic_28, R.drawable.bg_snow),
    "29" to Sky("浮尘", R.drawable.ic_29, R.drawable.bg_fog),
    "30" to Sky("扬沙", R.drawable.ic_30, R.drawable.bg_fog),
    "31" to Sky("强沙尘暴", R.drawable.ic_31, R.drawable.bg_fog),
    "32" to Sky("浓雾", R.drawable.ic_32, R.drawable.bg_fog),
    "39" to Sky("台风", R.drawable.ic_39, R.drawable.bg_fog),
    "49" to Sky("强浓雾", R.drawable.ic_49, R.drawable.bg_fog),
    "53" to Sky("霾", R.drawable.ic_53, R.drawable.bg_fog),
    "54" to Sky("中度霾", R.drawable.ic_54, R.drawable.bg_fog),
    "55" to Sky("重度霾", R.drawable.ic_55, R.drawable.bg_fog),
    "56" to Sky("严重霾", R.drawable.ic_56, R.drawable.bg_fog),
    "57" to Sky("大雾", R.drawable.ic_57, R.drawable.bg_fog),
    "58" to Sky("特强浓雾", R.drawable.ic_58, R.drawable.bg_fog),
    "99" to Sky("无", R.drawable.ic_99, R.drawable.bg_fog),
    "301" to Sky("雨", R.drawable.ic_301, R.drawable.bg_rain),
    "302" to Sky("雪", R.drawable.ic_302, R.drawable.bg_snow)
    )

fun getSky(skycon: String): Sky {
    return sky[skycon] ?: sky["0"]!!
}