package com.example.medanospaper.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.medanospaper.viewModel.PostViewModel

@Composable
fun CategoryListView(viewModel: PostViewModel, pad: PaddingValues, id: Int){
    ContentCategoryListView(viewModel, pad, id)
}
@Composable
fun ContentCategoryListView(viewModel: PostViewModel, pad: PaddingValues, id: Int){
    Box(modifier = Modifier.padding(pad)){
        Text("Listados de id: ${id}")
    }
}