package com.example.android.kotlinweatherapp.utils

import android.content.Context
import java.text.DateFormat
import java.util.*

/**
 * Created by BANACH on 11.12.2016.
 */

fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.getDefault())
    return df.format(this)
}