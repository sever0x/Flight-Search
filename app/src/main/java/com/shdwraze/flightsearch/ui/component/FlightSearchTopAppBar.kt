package com.shdwraze.flightsearch.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shdwraze.flightsearch.R
import com.shdwraze.flightsearch.ui.theme.FlightSearchTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlightSearchTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                modifier = Modifier.padding(start = 8.dp)
            )
        },
        colors = topAppBarColors(
            containerColor = Color.hsl(212f, 0.68f, 0.39f),
            titleContentColor = Color.White
        )
    )
}

@Preview
@Composable
fun PreviewBar() {
    FlightSearchTheme {
        FlightSearchTopAppBar()
    }
}