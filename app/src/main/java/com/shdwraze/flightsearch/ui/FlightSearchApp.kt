package com.shdwraze.flightsearch.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shdwraze.flightsearch.ui.airport.AirportsListScreen
import com.shdwraze.flightsearch.ui.airport.DestinationsList
import com.shdwraze.flightsearch.ui.component.FlightSearchTopAppBar
import com.shdwraze.flightsearch.ui.component.SearchField
import com.shdwraze.flightsearch.ui.theme.FlightSearchTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FlightSearchApp(
    flightSearchViewModel: FlightSearchViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val flightSearchUiState = flightSearchViewModel.flightSearchUiState.collectAsState()

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    val hideKeyboardAndClearFocus = {
        keyboardController?.hide()
        focusManager.clearFocus()
    }

    Scaffold(
        topBar = {
            FlightSearchTopAppBar()
        }
    ) { innerPadding ->
        var textState by remember { mutableStateOf(TextFieldValue("")) }

        Surface(
            modifier = Modifier.padding(innerPadding)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                SearchField(
                    textState = textState,
                    onCloseButtonClick = {
                        textState = TextFieldValue("")
                    },
                    onValueChange = {
                        textState = it
                        flightSearchViewModel.updateSearchQuery(it.text)
                        flightSearchViewModel.changeMode(Mode.SEARCH)
                    },
                    onClickSearchAction = {
                        hideKeyboardAndClearFocus()
                    }
                )

                if (textState.text.isNotEmpty() && flightSearchUiState.value.mode == Mode.SEARCH) {
                    AirportsListScreen(
                        airports = flightSearchUiState.value.airports,
                        onDepartureClick = {
                            hideKeyboardAndClearFocus()
                            flightSearchViewModel.changeMode(Mode.DESTINATIONS)
                            flightSearchViewModel.getDestinations(it)
                        }
                    )
                }

                if (flightSearchUiState.value.mode == Mode.DESTINATIONS) {
                    flightSearchUiState.value.departure?.let {
                        DestinationsList(
                            departureAirport = it,
                            destinations = flightSearchUiState.value.destinations
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    FlightSearchTheme {
        FlightSearchApp()
    }
}