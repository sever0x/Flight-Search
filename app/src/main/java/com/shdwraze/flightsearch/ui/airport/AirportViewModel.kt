package com.shdwraze.flightsearch.ui.airport

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shdwraze.flightsearch.data.repository.AirportRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class AirportViewModel(private val airportRepository: AirportRepository) : ViewModel() {

    private val airportQueryFlow = MutableStateFlow("")

    @OptIn(ExperimentalCoroutinesApi::class)
    val airportUiState: StateFlow<AirportUiState> = airportQueryFlow.flatMapLatest { query ->
        airportRepository.getAirportSearchStream(query)
            .map { AirportUiState(it) }
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = AirportUiState()
        )

    fun updateSearchQuery(query: String) {
        airportQueryFlow.value = query
        println(airportUiState.value.toString())
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}