package com.example.medanospaper.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.medanospaper.components.ActivityIndicator
import com.example.medanospaper.components.PostCard
import com.example.medanospaper.viewModel.PostViewModel

@Composable
fun HomeView(viewModel: PostViewModel, pad: PaddingValues, navController: NavController) {
    ContentHomeView(viewModel, pad, navController)
}

private val buffer = 1

@Composable
fun ContentHomeView(viewModel: PostViewModel, pad: PaddingValues, navController: NavController) {
    val posts by viewModel.posts.collectAsState()
    val loading by viewModel.loading.collectAsState()
    val loadingMorePosts by viewModel.loadingMorePosts.collectAsState()
    val listState = rememberLazyListState()
    val reachedBottom: Boolean by remember {
        derivedStateOf {
            val lastVisibleItem = listState.layoutInfo.visibleItemsInfo.lastOrNull()
            lastVisibleItem?.index != 0 && lastVisibleItem?.index == listState.layoutInfo.totalItemsCount - buffer
        }
    }

    LaunchedEffect(reachedBottom) {
        if (reachedBottom) {
            viewModel.loadMorePosts()
        }
    }
    if (loading) {
        ActivityIndicator(pad)
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(pad)
        ) {
            LazyColumn(
                state = listState,
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                itemsIndexed(posts) { idx, item ->
                    Box(
                        modifier = Modifier
                            .padding(top = if (idx > 1) 0.dp else 16.dp)
                            .clickable {

                            }
                    ) {
                        PostCard(item, navController, viewModel)
                    }
                }
            }
            if(loadingMorePosts) {
                CircularProgressIndicator(
                    modifier = Modifier.width(32.dp),
                    color = Color.Red,
                )
            }
        }
    }
}