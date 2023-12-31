package com.shdwraze.flightsearch.data.repository

import com.shdwraze.flightsearch.data.model.Airport
import kotlinx.coroutines.flow.Flow

interface AirportRepository {

    fun getAirportsStream(): Flow<List<Airport>>

    fun getAirportSearchStream(query: String): Flow<List<Airport>>

    fun getAirportsExceptQuery(query: String): Flow<List<Airport>>
}