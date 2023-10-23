package com.shdwraze.flightsearch

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shdwraze.flightsearch.ui.component.FlightSearchTopAppBar
import com.shdwraze.flightsearch.ui.component.SearchField
import com.shdwraze.flightsearch.ui.theme.FlightSearchTheme

@Composable
fun FlightSearchApp() {
    Scaffold(
        topBar = {
            FlightSearchTopAppBar()
        }
    ) { innerPadding ->
        var textState by remember { mutableStateOf(TextFieldValue("")) }

        Surface(
            modifier = Modifier.padding(innerPadding)
        ) {
            SearchField(
                modifier = Modifier.padding(PaddingValues(16.dp)),
                textState = textState,
                onCloseButtonClick = {
                    textState = TextFieldValue("")
                },
                onValueChange = {
                    textState = it
                }
            )
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