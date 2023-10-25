package com.shdwraze.flightsearch.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shdwraze.flightsearch.ui.theme.FlightSearchTheme

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    textState: TextFieldValue = TextFieldValue(""),
    onCloseButtonClick: (TextFieldValue) -> Unit = {},
    onValueChange: (TextFieldValue) -> Unit = {},
    onClickSearchAction: () -> Unit = {}
) {
    TextField(
        value = textState,
        onValueChange = { onValueChange(it) },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        placeholder = { Text("Enter departure airport") },
        shape = RoundedCornerShape(36.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        singleLine = true,
        trailingIcon = {
            if (textState.text.isNotEmpty()) {
                IconButton(onClick = { onCloseButtonClick(textState) }) {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = null
                    )
                }
            }
        },
        keyboardActions = KeyboardActions(
            onSearch = {
                onClickSearchAction()
            }
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        modifier = modifier.fillMaxWidth()
    )
}

@Preview
@Composable
fun SearchPrev() {
    FlightSearchTheme {
        SearchField()
    }
}