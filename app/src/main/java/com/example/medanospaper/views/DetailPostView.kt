package com.example.medanospaper.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.medanospaper.viewModel.PostViewModel

@Composable
fun DetailPostView(viewModel: PostViewModel, pad: PaddingValues) {
    ContentDetailPostView(viewModel, pad)
}

@Composable
fun ContentDetailPostView(viewModel: PostViewModel, pad: PaddingValues) {
    val selectedPost by viewModel.selectedPost.collectAsState()
    val scroll = rememberScrollState(0)
    DisposableEffect(Unit) {
        onDispose { viewModel.onCleanSelectPost() }
    }
    Column(
        modifier = Modifier
            .padding(pad)
            .verticalScroll(scroll)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(16.dp)
        ) {
            val image =
                rememberImagePainter(data = selectedPost.jetpack_featured_media_url)
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
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = selectedPost.title.rendered,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = selectedPost.content.rendered,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
            )   
        }
    }
}