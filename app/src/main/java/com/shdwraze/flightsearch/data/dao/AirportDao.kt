package com.shdwraze.flightsearch.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.shdwraze.flightsearch.data.model.Airport
import kotlinx.coroutines.flow.Flow

@Dao
interface AirportDao {
    @Query("select * from airport order by name asc")
    fun getAirports(): Flow<List<Airport>>

    @Query(
        "select * from airport where name like '%' || :query || '%' or " +
                "iata_code like '%' || :query || '%' order by passengers desc"
    )
    fun getAirportsLikeQuery(query: String): Flow<List<Airport>>

    @Query("select * from airport where iata_code <> :query order by name asc")
    fun getAirportsExceptQuery(query: String): Flow<List<Airport>>
}