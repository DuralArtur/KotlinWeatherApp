package com.example.android.kotlinweatherapp

/**
 * Created by BANACH on 09.12.2016.
 */
public interface Command<T> {
    fun execute(): T
}