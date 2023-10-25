package com.shdwraze.flightsearch.ui

import com.shdwraze.flightsearch.data.model.Airport

data class FlightSearchUiState(
    val airports: List<Airport> = listOf(),
    val destinations: List<Airport> = listOf(),
    val departure: Airport? = null
)
