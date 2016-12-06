package com.example.android.kotlinweatherapp

import android.util.Log
import java.net.URL

/**
 * Created by Artur on 06-Dec-16.
 */
class Request(val url: String) {
    fun run(){
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName,forecastJsonStr)
    }
}