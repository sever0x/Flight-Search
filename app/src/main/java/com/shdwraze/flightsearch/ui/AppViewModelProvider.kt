package com.shdwraze.flightsearch.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.shdwraze.flightsearch.FlightSearchApplication
import com.shdwraze.flightsearch.ui.airport.AirportViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            AirportViewModel(
                flightSearchApplication().container.airportRepository
            )
        }
    }
}

fun CreationExtras.flightSearchApplication(): FlightSearchApplication =
    (this[APPLICATION_KEY] as FlightSearchApplication)