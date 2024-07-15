package com.example.medanospaper.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SearchView(pad: PaddingValues) {
    ContentSearchView(pad)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentSearchView(pad: PaddingValues) {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(pad)
    ) {

        TextField(
            value = text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            placeholder = {
                Text(
                    text = "¿Qué estás buscando?",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            },
            onValueChange = { newText ->
                text = newText
            },
            shape = RoundedCornerShape(8.dp),
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color(0xFFECECEC),
                unfocusedContainerColor = Color(0xFFECECEC),
                disabledContainerColor = Color(0xFFECECEC),
            ),

            )
    }
}