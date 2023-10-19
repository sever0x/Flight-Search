package com.shdwraze.flightsearch

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shdwraze.flightsearch.ui.component.FlightSearchTopAppBar
import com.shdwraze.flightsearch.ui.theme.FlightSearchTheme

@Composable
fun FlightSearchApp() {
    Scaffold(
        topBar = {
            FlightSearchTopAppBar()
        }
    ) { innerPadding ->
        Text(
            text = "Hello",
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview
@Composable
fun Preview() {
    FlightSearchTheme {
        FlightSearchApp()
    }
}