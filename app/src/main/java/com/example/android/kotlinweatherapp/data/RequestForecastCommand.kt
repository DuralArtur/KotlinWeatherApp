package com.example.android.kotlinweatherapp.data

import com.example.android.kotlinweatherapp.Command
import com.example.android.kotlinweatherapp.DataMapper
import com.example.android.kotlinweatherapp.ForecastProvider
import com.example.android.kotlinweatherapp.db.ForecastList

/**
 * Created by BANACH on 09.12.2016.
 */
class RequestForecastCommand(val zipCode: Long, val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<ForecastList> {
    companion object {
        val DAYS = 7
}

    override fun execute(): ForecastList {
        return forecastProvider.requestByZipCode(zipCode, DAYS)
    }
}