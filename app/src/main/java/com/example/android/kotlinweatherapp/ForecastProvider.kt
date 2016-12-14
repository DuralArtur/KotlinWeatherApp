package com.example.android.kotlinweatherapp

import com.example.android.kotlinweatherapp.db.Forecast
import com.example.android.kotlinweatherapp.db.ForecastDB
import com.example.android.kotlinweatherapp.db.ForecastList
import com.example.android.kotlinweatherapp.db.ForecastServer
import com.example.android.kotlinweatherapp.utils.ForecastDataSource
import com.example.android.kotlinweatherapp.utils.firstResult

/**
 * Created by BANACH on 11.12.2016.
 */
class ForecastProvider(val sources: List<ForecastDataSource> = ForecastProvider.SOURCES) {
    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES by lazy { listOf(ForecastDB(), ForecastServer()) }
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = requestToSources {
        val res = it.requestForecastByZipCode(zipCode, todayTimeSpan())
        if(res != null && res.size() >= days) res else null
    }

    fun requestForecast(id: Long): Forecast = requestToSources {
        it.requestDayForecast(id)
    }

    private fun <T : Any> requestToSources(f: (ForecastDataSource) -> T?): T
            = sources.firstResult { f(it) }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS
}