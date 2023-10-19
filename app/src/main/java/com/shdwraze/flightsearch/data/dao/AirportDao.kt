package com.shdwraze.flightsearch.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.shdwraze.flightsearch.data.model.Airport
import kotlinx.coroutines.flow.Flow

@Dao
interface AirportDao {
    @Query("select * from airport where iata_code = :iataCode")
    fun getAirportByIataCode(iataCode: String): Flow<Airport>

    @Query("select * from airport order by name asc")
    fun getAirports(): Flow<List<Airport>>
}