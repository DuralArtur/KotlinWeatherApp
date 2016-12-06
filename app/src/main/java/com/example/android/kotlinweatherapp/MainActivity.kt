package com.example.android.kotlinweatherapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity() {

    private val listOfForecasts = listOf("Poniedzialek, pada",
            "Wtorek, pada",
            "Sroda, pada",
            "Czwartek, pada",
            "Piatek, pada"
            )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val forecastList: RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(listOfForecasts)
    }
}
