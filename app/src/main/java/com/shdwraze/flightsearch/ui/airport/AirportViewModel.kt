package com.shdwraze.flightsearch.ui.airport

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shdwraze.flightsearch.data.repository.AirportRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class AirportViewModel(private val airportRepository: AirportRepository) : ViewModel() {

    val airportUiState: StateFlow<AirportUiState> = airportRepository.getAirportsStream()
        .map { AirportUiState(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = AirportUiState()
        )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}