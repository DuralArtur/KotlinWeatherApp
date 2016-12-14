package com.example.android.kotlinweatherapp

import com.example.android.kotlinweatherapp.Command
import com.example.android.kotlinweatherapp.ForecastProvider
import com.example.android.kotlinweatherapp.db.Forecast

/**
 * Created by BANACH on 11.12.2016.
 */
class RequestDayForecastCommand(
        val id: Long,
        val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<Forecast> {

    override fun execute() = forecastProvider.requestForecast(id)
}

