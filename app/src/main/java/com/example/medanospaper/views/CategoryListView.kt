package com.example.medanospaper.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.medanospaper.components.ActivityIndicator
import com.example.medanospaper.components.PostCard
import com.example.medanospaper.model.postsCategories
import com.example.medanospaper.viewModel.PostViewModel

@Composable
fun CategoryListView(viewModel: PostViewModel, pad: PaddingValues, id: Int, navController: NavController){
    ContentCategoryListView(viewModel, pad, id, navController)
}
@Composable
fun ContentCategoryListView(viewModel: PostViewModel, pad: PaddingValues, id: Int, navController: NavController){
    LaunchedEffect(Unit) {
        viewModel.fetchPostsByCategoryId(categories = id)
    }
    DisposableEffect(Unit) {
        onDispose { viewModel.onCleanPostsByCategory() }
    }

    val posts by viewModel.postsByCategory.collectAsState()
    val loading by viewModel.loadingByCategory.collectAsState()
    if(loading) {
        ActivityIndicator(pad)
    } else {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(pad)
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
    }
}