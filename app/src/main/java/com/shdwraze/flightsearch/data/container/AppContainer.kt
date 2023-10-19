package com.shdwraze.flightsearch.data.container

import android.content.Context
import com.shdwraze.flightsearch.data.database.FlightSearchDatabase
import com.shdwraze.flightsearch.data.repository.AirportRepository
import com.shdwraze.flightsearch.data.repository.FavoriteRepository
import com.shdwraze.flightsearch.data.repository.OfflineAirportRepository
import com.shdwraze.flightsearch.data.repository.OfflineFavoriteRepository

interface AppContainer {
    val airportRepository: AirportRepository

    val favoriteRepository: FavoriteRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val airportRepository: AirportRepository by lazy {
        OfflineAirportRepository(FlightSearchDatabase.getDatabase(context).airportDao())
    }

    override val favoriteRepository: FavoriteRepository by lazy {
        OfflineFavoriteRepository(FlightSearchDatabase.getDatabase(context).favoriteDao())
    }
}