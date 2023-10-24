package com.shdwraze.flightsearch.ui.airport

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shdwraze.flightsearch.data.model.Airport

@Composable
fun AirportsScreen(
    airports: List<Airport>
) {
    LazyColumn {
        items(airports) { item ->
            Text(
                text = item.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { }
            )
        }
    }
}