package com.example.medanospaper.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.medanospaper.components.BottomNav
import com.example.medanospaper.components.MainTopBar
import com.example.medanospaper.navigation.NavManager
import com.example.medanospaper.navigation.Routes
import com.example.medanospaper.viewModel.PostViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TabView(viewModel: PostViewModel){
    val navController = rememberNavController()
    val navigationRoutes = listOf(
        Routes.HomeView,
        Routes.SearchView,
        Routes.CategoryView
    )
    //navController.currentDestination
    Scaffold(
        topBar = {
            MainTopBar(title = "Medanos Paper", onClickBackButton = {}) {}
        },
        bottomBar = {
            BottomNav(navController, navigationRoutes)
        }
    ) {
        pad ->
        NavManager(navController, viewModel, pad)
    }
}