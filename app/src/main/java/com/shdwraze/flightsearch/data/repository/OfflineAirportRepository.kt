package com.shdwraze.flightsearch.data.repository

import com.shdwraze.flightsearch.data.dao.AirportDao
import com.shdwraze.flightsearch.data.model.Airport
import kotlinx.coroutines.flow.Flow

class OfflineAirportRepository(
    private val airportDao: AirportDao
) : AirportRepository {
    override fun getAirportsStream(): Flow<List<Airport>> = airportDao.getAirports()

    override fun getAirportSearchStream(query: String): Flow<List<Airport>> =
        airportDao.getAirportsLikeQuery(query)

    override fun getAirportsExceptQuery(query: String): Flow<List<Airport>> =
        airportDao.getAirportsExceptQuery(query)
}