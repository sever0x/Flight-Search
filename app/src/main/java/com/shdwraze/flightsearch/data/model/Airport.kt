package com.shdwraze.flightsearch.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "airports")
data class Airport(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val iataCode: String,
    val name: String,
    val passangers: Int
)