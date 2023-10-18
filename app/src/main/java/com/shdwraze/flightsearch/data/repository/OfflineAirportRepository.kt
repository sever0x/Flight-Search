package com.shdwraze.flightsearch.data.repository

import com.shdwraze.flightsearch.data.dao.AirportDao
import com.shdwraze.flightsearch.data.model.Airport
import kotlinx.coroutines.flow.Flow

class OfflineAirportRepository(
    private val airportDao: AirportDao
) : AirportRepository {
    override fun getAirportsStream(): Flow<List<Airport>> = airportDao.getAirports()

    override fun getAirportStream(iataCode: String): Flow<Airport?> =
        airportDao.getAirportByIataCode(iataCode)
}