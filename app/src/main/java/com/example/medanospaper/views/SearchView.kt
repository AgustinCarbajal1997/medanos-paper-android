package com.example.medanospaper.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.medanospaper.components.ActivityIndicator
import com.example.medanospaper.components.PostCard
import com.example.medanospaper.viewModel.PostViewModel

@Composable
fun SearchView(pad: PaddingValues, viewModel: PostViewModel, navController: NavController) {
    ContentSearchView(pad, viewModel, navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentSearchView(pad: PaddingValues, viewModel: PostViewModel, navController: NavController) {
    val search by viewModel.search.collectAsState()
    val searchPosts by viewModel.searchPosts.collectAsState()
    val loadingSearch by viewModel.loadingSearch.collectAsState()
    val keyboardController = LocalSoftwareKeyboardController.current
    Column(
        modifier = Modifier
            .padding(pad)
    ) {
        TextField(
            value = search,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            placeholder = {
                Text(
                    text = "¿Qué estás buscando?",
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            },
            trailingIcon = {
                if(searchPosts.isNotEmpty() && search.length > 0) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "Clear Icon",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .size(14.dp)
                            .clickable {
                                viewModel.onCleanSearchPosts()
                            }
                    )
                }
            },
            onValueChange = { newText ->
                viewModel.onChangeSearchText(newText)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            singleLine = true,
            keyboardActions = KeyboardActions(
                onSearch = {
                    viewModel.onSubmitSearch()
                    keyboardController?.hide()
                }
            ),
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
        if (loadingSearch) {
            ActivityIndicator(pad)
        } else {
            Box(
                contentAlignment = Alignment.Center
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    itemsIndexed(searchPosts) { idx, item ->
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
    }
}