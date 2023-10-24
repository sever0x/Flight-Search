package com.shdwraze.flightsearch.ui.airport

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.shdwraze.flightsearch.data.model.Airport

@Composable
fun AirportsScreen(
    airports: List<Airport>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(airports) { item ->
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                        append(item.iataCode)
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Light)) {
                        append(" ${item.name}")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}