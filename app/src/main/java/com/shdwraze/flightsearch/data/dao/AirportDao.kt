package com.shdwraze.flightsearch.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.shdwraze.flightsearch.data.model.Airport
import kotlinx.coroutines.flow.Flow

@Dao
interface AirportDao {
    @Query("select * from airports where iataCode = :iataCode")
    fun getAirportByIataCode(iataCode: String): Flow<Airport>

    @Query("select * from airports order by name asc")
    fun getAirports(): Flow<List<Airport>>
}