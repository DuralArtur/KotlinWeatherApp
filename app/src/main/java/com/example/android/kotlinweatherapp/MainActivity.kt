package com.example.android.kotlinweatherapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.android.kotlinweatherapp.data.RequestForecastCommand
import org.jetbrains.anko.async
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

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

        forecastList.layoutManager = LinearLayoutManager(this)
        async(){
            val result = RequestForecastCommand(94043).execute()
            Log.v("co sie odpierdala","razz")
            uiThread {
                val adapter = ForecastListAdapter(result) {
//                    startActivity<DetailActivity>(DetailActivity.ID to it.id,
//                            DetailActivity.CITY_NAME to result.city)
                }
                forecastList.adapter = adapter
            }
        }
    }
}
