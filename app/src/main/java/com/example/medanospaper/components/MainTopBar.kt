package com.example.medanospaper.components

import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    title: String,
    showBackButton: Boolean = false,
    onClickBackButton: () -> Unit,
    onClickAction: () -> Unit
) {
    TopAppBar(title = {
        Text(
            text = title,
            color = Color.White,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 16.sp
        )
    },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        ),
        //navigationIcon = {
        //    if (showBackButton) {
        //        IconButton(onClick = { onClickBackButton() }) {
        //            Icon(
        //                imageVector = Icons.Default.ArrowBack,
        //                contentDescription = "",
        //                tint = Color.White
        //            )
        //        }
        //    }
        //},
        //actions = {
        //    if (!showBackButton) {
        //        IconButton(onClick = { onClickAction() }) {
        //            Icon(
        //                imageVector = Icons.Default.Search,
        //                contentDescription = "",
        //                tint = Color.White
        //            )
        //        }
        //    }
        //}
    )
}