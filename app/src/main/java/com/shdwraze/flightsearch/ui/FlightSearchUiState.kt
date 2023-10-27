package com.shdwraze.flightsearch.ui

import com.shdwraze.flightsearch.data.model.Airport
import com.shdwraze.flightsearch.data.model.Favorite

data class FlightSearchUiState(
    val airports: List<Airport> = listOf(),
    val destinations: List<Airport> = listOf(),
    val favorites: List<Favorite> = listOf(),
    val departure: Airport? = null,
    val mode: Mode = Mode.NONE,
    val searchQuery: String = ""
)

enum class Mode {
    NONE, SEARCH, DESTINATIONS
}