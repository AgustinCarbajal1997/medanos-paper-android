package com.example.medanospaper.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.medanospaper.model.PostModel
import com.example.medanospaper.viewModel.PostViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostCard(post: PostModel, navController: NavController, viewModel: PostViewModel) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        onClick = {
            viewModel.onSelectPost(post)
            navController.navigate("DetailPostView")
        },
        //elevation = CardDefaults.cardElevation(
        //    defaultElevation = 6.dp
        //),
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
        ) {
            val image =
                rememberImagePainter(data = post.jetpack_featured_media_url)
            Box(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
            ) {
                Image(
                    painter = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(10.dp))
                )
            }
            Box(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight()
                    .padding(8.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = post.title.rendered,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp,
                    lineHeight = 18.sp
                )
            }
        }
    }
}