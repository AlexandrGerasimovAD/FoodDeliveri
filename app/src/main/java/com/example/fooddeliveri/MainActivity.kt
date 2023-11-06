package com.example.fooddeliveri

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.fooddeliveri.Viev.MainScreen
import com.example.fooddeliveri.ui.theme.BackGroundColor
import com.example.fooddeliveri.ui.theme.FoodDeliveriTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController= rememberNavController()
            FoodDeliveriTheme {
                NavHost(navController =navController , startDestination = "MainScreen"){
                    composable("MainScreen"){}
                }
                Column(
                    Modifier
                        .background(color = BackGroundColor)
                        .fillMaxSize()) {
                    MainScreen()

                }

            }
        }
    }
}



