package com.shdwraze.flightsearch

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shdwraze.flightsearch.ui.AppViewModelProvider
import com.shdwraze.flightsearch.ui.airport.AirportViewModel
import com.shdwraze.flightsearch.ui.airport.AirportsScreen
import com.shdwraze.flightsearch.ui.component.FlightSearchTopAppBar
import com.shdwraze.flightsearch.ui.component.SearchField
import com.shdwraze.flightsearch.ui.theme.FlightSearchTheme

@Composable
fun FlightSearchApp(
    airportViewModel: AirportViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val airportUiState = airportViewModel.airportUiState.collectAsState()

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
                        airportViewModel.updateSearchQuery(it.text)
                    }
                )

                if (textState.text.isNotEmpty()) {
                    AirportsScreen(
                        airports = airportUiState.value.airports
                    )
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