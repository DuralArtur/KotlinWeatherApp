package com.example.android.kotlinweatherapp

import com.example.android.kotlinweatherapp.data.ForecastResult
import java.text.DateFormat
import java.util.*
import com.example.android.kotlinweatherapp.data.Forecast
import com.example.android.kotlinweatherapp.db.ForecastList
import com.example.android.kotlinweatherapp.db.Forecast as ModelForecast
/**
 * Created by BANACH on 09.12.2016.
 */


class DataMapper {
    fun convertToDomain(zipCode: Long, forecast: ForecastResult) = with(forecast) {
        ForecastList(zipCode, city.name, city.country, convertForecastListToDomain(list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast) = with(forecast) {
        ModelForecast(-1, dt * 1000, weather[0].description, temp.max.toInt(), temp.min.toInt(),
                generateIconUrl(weather[0].icon))
    }

    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/w/$iconCode.png"
}