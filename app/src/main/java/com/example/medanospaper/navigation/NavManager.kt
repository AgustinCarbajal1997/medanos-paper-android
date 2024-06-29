package com.example.medanospaper.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.medanospaper.viewModel.PostViewModel
import com.example.medanospaper.views.CategoryView
import com.example.medanospaper.views.DetailPostView
import com.example.medanospaper.views.HomeView
import com.example.medanospaper.views.SearchView

@Composable
fun NavManager(navHostController: NavHostController, viewModel: PostViewModel, pad: PaddingValues){
    NavHost(navController = navHostController, startDestination = Routes.HomeView.route){
        composable(Routes.HomeView.route){
            HomeView(viewModel, pad, navHostController)
        }
        composable(Routes.DetailPostView.route){
            DetailPostView(viewModel, pad)
        }
        composable(Routes.SearchView.route){
            SearchView()
        }
        composable(Routes.CategoryView.route){
            CategoryView()
        }
    }

}