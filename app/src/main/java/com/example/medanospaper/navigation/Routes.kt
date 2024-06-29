package com.example.medanospaper.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Routes (
    val icon: ImageVector,
    val title: String,
    val route: String
) {
    object HomeView: Routes(Icons.Default.Home, "Últimas", "HomeView")
    object DetailPostView: Routes(Icons.Default.Home, "Detalle", "DetailPostView")
    object SearchView: Routes(Icons.Default.Search, "Buscador", "SearchView")
    object CategoryView: Routes(Icons.Default.List, "Categorías", "CategoryView")
}