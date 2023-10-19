package com.shdwraze.flightsearch.ui.airport

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shdwraze.flightsearch.ui.AppViewModelProvider

@Composable
fun AirportsScreen(
    airportViewModel: AirportViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val airportUiState by airportViewModel.airportUiState.collectAsState()

    Text(text = airportUiState.airports.size.toString())
}