package com.example.android.kotlinweatherapp.db

import com.example.android.kotlinweatherapp.DataMapper
import com.example.android.kotlinweatherapp.data.ForecastByZipCodeRequest
import com.example.android.kotlinweatherapp.utils.ForecastDataSource

/**
 * Created by BANACH on 11.12.2016.
 */
class ForecastServer(val dataMapper: DataMapper = DataMapper(),
                     val forecastDB: ForecastDB = ForecastDB()) : ForecastDataSource {
    override fun requestForecastByZipCode(zipcode: Long, data: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipcode).execute()
        val converted = dataMapper.convertToDomain(zipcode, result)
        forecastDB.saveForecast(converted)
        return forecastDB.requestForecastByZipCode(zipcode, data)
    }

    override fun requestDayForecast(id: Long): Forecast? {
        throw UnsupportedOperationException()}

}