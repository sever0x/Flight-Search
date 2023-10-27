package com.shdwraze.flightsearch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shdwraze.flightsearch.data.model.Airport
import com.shdwraze.flightsearch.data.repository.AirportRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class FlightSearchViewModel(private val airportRepository: AirportRepository) : ViewModel() {

    private val _flightSearchUiState = MutableStateFlow(FlightSearchUiState())
    val flightSearchUiState: StateFlow<FlightSearchUiState> = _flightSearchUiState

    init {
        updateSearchResult()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun updateSearchResult() {
        flightSearchUiState.flatMapLatest { state ->
            airportRepository.getAirportSearchStream(state.searchQuery)
                .map { airports -> state.copy(airports = airports) }
        }
            .onEach {
                _flightSearchUiState.value = it
            }
            .launchIn(viewModelScope)
    }

    fun getDestinations(airport: Airport) {
        viewModelScope.launch {
            airportRepository.getAirportsExceptQuery(airport.iataCode).collect { destinations ->
                _flightSearchUiState.value = _flightSearchUiState.value.copy(
                    destinations = destinations,
                    departure = airport
                )
            }
        }
    }

    fun updateSearchQuery(query: String) {
        _flightSearchUiState.value = _flightSearchUiState.value.copy(
            searchQuery = query
        )
    }
}