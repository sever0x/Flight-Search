package com.shdwraze.flightsearch.ui.airport

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shdwraze.flightsearch.data.model.Airport
import com.shdwraze.flightsearch.ui.airport.component.AirportTextLabel

@Composable
fun AirportsListScreen(
    airports: List<Airport>,
    modifier: Modifier = Modifier,
    onDepartureClick: (Airport) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(airports) { item ->
            AirportTextLabel(
                name = item.name, iataCode = item.iataCode,
                onDepartureClick = { onDepartureClick(item) }
            )
        }
    }
}