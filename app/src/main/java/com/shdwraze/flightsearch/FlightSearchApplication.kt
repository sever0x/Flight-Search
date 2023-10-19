package com.shdwraze.flightsearch

import android.app.Application
import com.shdwraze.flightsearch.data.container.AppContainer
import com.shdwraze.flightsearch.data.container.AppDataContainer

class FlightSearchApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}