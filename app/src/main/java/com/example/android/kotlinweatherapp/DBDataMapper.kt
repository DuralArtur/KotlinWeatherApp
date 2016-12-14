package com.example.android.kotlinweatherapp

import android.util.Log
import com.example.android.kotlinweatherapp.db.CityForecast
import com.example.android.kotlinweatherapp.db.DayForecast
import com.example.android.kotlinweatherapp.db.Forecast
import com.example.android.kotlinweatherapp.db.ForecastList


/**
 * Created by BANACH on 11.12.2016.
 */
class DBDataMapper {
    fun convertFromDomain(forecast: ForecastList) = with(forecast) {
        val daily = dailyForecast.map { convertDayFromDomain(id, it) }
        CityForecast(id, city, country, daily)
    }

    private fun convertDayFromDomain(cityId: Long, forecast: Forecast) = with(forecast) {
        DayForecast(date, description, high, low, iconUrl, cityId)
    }

    fun convertToDomain(forecast: CityForecast) = with(forecast) {
        val daily = dailyForecast.map { convertDayToDomain(it) }
        ForecastList(_id, city, country, daily)
    }

    fun convertDayToDomain(dayForecast: DayForecast) = with(dayForecast) {
        Forecast(_id, date, description, high, low, iconUrl)
    }
}