package com.shdwraze.flightsearch.ui.airport.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shdwraze.flightsearch.data.model.Airport

@Composable
fun FlightFromCard(
    modifier: Modifier = Modifier,
    departAirport: Airport,
    arriveAirport: Airport
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    top = 16.dp,
                    bottom = 16.dp,
                    end = 8.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(text = "DEPART")
                CardTextLabel(iataCode = departAirport.iataCode, name = departAirport.name)
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = "ARRIVE")
                CardTextLabel(iataCode = arriveAirport.iataCode, name = arriveAirport.name)
            }
            Box(modifier = Modifier.size(48.dp)) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    tint = Color.Gray
                )
            }
        }
    }
}

@Composable
fun CardTextLabel(
    iataCode: String,
    name: String
) {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                append(iataCode)
            }
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp
                )
            ) {
                append(" $name")
            }
        }
    )
}