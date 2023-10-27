package com.shdwraze.flightsearch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shdwraze.flightsearch.data.model.Airport
import com.shdwraze.flightsearch.data.model.Favorite
import com.shdwraze.flightsearch.data.repository.AirportRepository
import com.shdwraze.flightsearch.data.repository.FavoriteRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class FlightSearchViewModel(
    private val airportRepository: AirportRepository,
    private val favoriteRepository: FavoriteRepository
) : ViewModel() {

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

    fun addDestinationToFavorite(departAirport: Airport, destinationAirport: Airport) {
        viewModelScope.launch {
            favoriteRepository.insertFavorite(
                Favorite(
                    departureCode = departAirport.iataCode,
                    destinationCode = destinationAirport.iataCode
                )
            )
            updateFavorites()
        }
    }

    private fun updateFavorites() {
        favoriteRepository.getFavoritesStream().map { favorites ->
            _flightSearchUiState.value = _flightSearchUiState.value.copy(
                favorites = favorites
            )
        }
    }

    fun changeMode(mode: Mode) {
        _flightSearchUiState.value = _flightSearchUiState.value.copy(
            mode = mode
        )
    }

    fun updateSearchQuery(query: String) {
        _flightSearchUiState.value = _flightSearchUiState.value.copy(
            searchQuery = query
        )
    }
}