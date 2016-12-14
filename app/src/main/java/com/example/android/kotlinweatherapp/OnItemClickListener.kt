package com.example.android.kotlinweatherapp

import com.example.android.kotlinweatherapp.db.Forecast

/**
 * Created by BANACH on 10.12.2016.
 */
interface OnItemClickListener {
    operator fun invoke(forecast: Forecast)
}