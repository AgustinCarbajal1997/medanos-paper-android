package com.example.medanospaper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.medanospaper.ui.theme.MedanospaperTheme
import com.example.medanospaper.views.TabView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MedanospaperTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    TabView()
                }
            }
        }
    }
}




