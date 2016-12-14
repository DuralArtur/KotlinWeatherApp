package com.example.android.kotlinweatherapp

import android.app.Application
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by BANACH on 10.12.2016.
 */
class App : Application() {
    companion object {
            var instance: App by DelegatesExt.notNullSingleValue()    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}
