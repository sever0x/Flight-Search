package com.shdwraze.flightsearch.ui.airport.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle

@Composable
fun AirportTextLabel(
    name: String,
    iataCode: String,
    modifier: Modifier = Modifier,
    onDepartureClick: (String) -> Unit = {}
) {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                append(iataCode)
            }
            withStyle(style = SpanStyle(fontWeight = FontWeight.Light)) {
                append(" $name")
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onDepartureClick(iataCode)
            }
    )
}