package com.shdwraze.flightsearch.data.repository

import com.shdwraze.flightsearch.data.model.Airport
import kotlinx.coroutines.flow.Flow

interface AirportRepository {

    fun getAirportsStream(): Flow<List<Airport>>

    fun getAirportStream(iataCode: String): Flow<Airport?>
}