package com.shdwraze.flightsearch.ui.airport

import com.shdwraze.flightsearch.data.model.Airport
import kotlinx.coroutines.flow.StateFlow

data class AirportUiState(
    val airports: List<Airport> = listOf()
)
