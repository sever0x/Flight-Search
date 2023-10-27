package com.shdwraze.flightsearch.ui.airport

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shdwraze.flightsearch.data.model.Airport
import com.shdwraze.flightsearch.ui.airport.component.DestinationCard

@Composable
fun DestinationsList(
    departureAirport: Airport,
    destinations: List<Airport>,
    modifier: Modifier = Modifier,
    onAddToFavoriteClick: (Airport, Airport) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(destinations) { destination ->
            DestinationCard(
                departAirport = departureAirport,
                destinationAirport = destination,
                onAddToFavoriteClick = onAddToFavoriteClick
            )
        }
    }
}