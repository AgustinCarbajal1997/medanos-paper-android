package com.example.medanospaper.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.medanospaper.components.BottomNav
import com.example.medanospaper.navigation.NavManager
import com.example.medanospaper.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TabView(){
    val navController = rememberNavController()
    val navigationRoutes = listOf(
        Routes.HomeView,
        Routes.SearchView,
        Routes.CategoryView
    )

    Scaffold(
        bottomBar = {
            BottomNav(navController, navigationRoutes )
        }
    ) {
        NavManager(navController)
    }
}