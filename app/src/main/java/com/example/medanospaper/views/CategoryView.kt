package com.example.medanospaper.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.medanospaper.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.medanospaper.model.postsCategories
import com.example.medanospaper.ui.theme.Font
import com.example.medanospaper.viewModel.PostViewModel

@Composable
fun CategoryView(viewModel: PostViewModel, pad: PaddingValues, navController: NavController) {
    ContentCategoryView(viewModel, pad, navController)
}

@Composable
fun ContentCategoryView(viewModel: PostViewModel, pad: PaddingValues, navController: NavController) {
    val image = R.drawable.agro
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(pad)
    ) {
        itemsIndexed(postsCategories) { idx, it ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = if (idx > 1) 0.dp else 16.dp)
                    .clickable {
                        navController.navigate("CategoryListView/${it.id}")
                    }
            ) {
                Box(
                    modifier = Modifier
                        .height(160.dp)
                        .width(160.dp)
                ) {
                    Image(
                        painterResource(id = it.image),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(10.dp))
                    )
                }
                Text(
                    text = it.name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }


        }
    }
}