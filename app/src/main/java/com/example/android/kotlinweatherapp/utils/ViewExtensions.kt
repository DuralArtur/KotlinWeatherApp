package com.example.android.kotlinweatherapp.utils

import android.content.Context
import android.view.View
import android.widget.TextView

/**
 * Created by BANACH on 10.12.2016.
 */

val View.ctx: Context
get() = context


public fun Context.color(res: Int): Int = android.support.v4.content.ContextCompat.getColor(this,res)

var TextView.textColor: Int
get() = currentTextColor
set(v) = setTextColor(v)