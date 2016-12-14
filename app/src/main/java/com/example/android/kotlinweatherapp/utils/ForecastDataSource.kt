package com.example.android.kotlinweatherapp.utils

import com.example.android.kotlinweatherapp.db.Forecast
import com.example.android.kotlinweatherapp.db.ForecastList

/**
 * Created by BANACH on 11.12.2016.
 */
interface ForecastDataSource {
    fun requestForecastByZipCode(zipcode: Long, data: Long): ForecastList?
    fun requestDayForecast(id:Long): Forecast?
}