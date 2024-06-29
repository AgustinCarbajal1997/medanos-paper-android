package com.example.medanospaper.components

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.medanospaper.navigation.Routes

@Composable
fun BottomNav(navHostController: NavHostController, routes: List<Routes>) {
    BottomAppBar() {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.inverseOnSurface,
        ) {
            val currentRoute = currentRoute(navHostController)
            routes.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.route,
                    onClick = { navHostController.navigate(item.route) },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = MaterialTheme.colorScheme.secondary,
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            color = if (currentRoute == item.route) Color.DarkGray else Color.Gray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    },

                )
            }
        }
    }
}


@Composable
fun currentRoute(navHostController: NavHostController): String? {
    val current by navHostController.currentBackStackEntryAsState()
    return current?.destination?.route
}