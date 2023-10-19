package com.shdwraze.flightsearch

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.shdwraze.flightsearch.ui.airport.AirportsScreen
import com.shdwraze.flightsearch.ui.theme.FlightSearchTheme

@Composable
fun FlightSearchApp() {
    AirportsScreen()
}

@Preview
@Composable
fun Preview() {
    FlightSearchTheme {
        FlightSearchApp()
    }
}