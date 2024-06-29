package com.example.medanospaper.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.medanospaper.components.PostCard
import com.example.medanospaper.viewModel.PostViewModel

@Composable
fun HomeView(viewModel: PostViewModel, pad: PaddingValues, navController: NavController) {
    ContentHomeView(viewModel, pad, navController)
}

@Composable
fun ContentHomeView(viewModel: PostViewModel, pad: PaddingValues, navController: NavController) {
    val posts by viewModel.posts.collectAsState()
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(pad)
    ) {
        items(posts) { item ->
                PostCard(item, navController, viewModel)
        }
    }
}