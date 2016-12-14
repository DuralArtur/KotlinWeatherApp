package com.example.android.kotlinweatherapp.db

import com.example.android.kotlinweatherapp.DBDataMapper
import com.example.android.kotlinweatherapp.DataMapper
import java.util.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import com.example.android.kotlinweatherapp.utils.*


/**
 * Created by BANACH on 11.12.2016.
 */
class ForecastDB (val forecastDBHelper: ForecastDBHelper = ForecastDBHelper.instance,
                  val dataMapper: DBDataMapper = DBDataMapper()) : ForecastDataSource{
    override fun requestForecastByZipCode(zipCode: Long, date: Long) =
            forecastDBHelper.use{
        val dailyRequest = "${DayForecastTable.CITY_ID} = ?" +
                "AND ${DayForecastTable.DATE} >= ?"
        val dailyForecast = select(DayForecastTable.NAME)
                .whereSimple(dailyRequest, zipCode.toString(),
                        date.toString())
                .parseList { DayForecast(HashMap(it))}

                val city = select(CityForecastTable.NAME)
                        .whereSimple("${CityForecastTable.ID} = ?", zipCode.toString())
                        .parseOpt { CityForecast(HashMap(it), dailyForecast) }
            if(city!=null) dataMapper.convertToDomain(city) else null}

    fun saveForecast(forecast: ForecastList) = forecastDBHelper.use {

        clear(CityForecastTable.NAME)
        clear(DayForecastTable.NAME)

        with(dataMapper.convertFromDomain(forecast)) {
            insert(CityForecastTable.NAME, *map.toVarargArray())
            dailyForecast.forEach { insert(DayForecastTable.NAME, *it.map.toVarargArray()) }
        }
    }

    override fun requestDayForecast(id:Long): Forecast? = forecastDBHelper.use {
        val forecast = select(DayForecastTable.NAME).byId(id).
                parseOpt {DayForecast(HashMap(it))}
        if (forecast !=null) dataMapper.convertDayToDomain(forecast) else null
    }
}

