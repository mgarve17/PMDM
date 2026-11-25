package com.example.ut2_3.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ut2_3.views.DetailView
import com.example.ut2_3.views.HomeView

@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, // asignamos val de estado
        startDestination = "Home" // navegacion empieza en Home
    ) {
        composable(route = "Home") { // Ruta Home para HomeView
            HomeView(navController)
        }
        composable(route = "Detail") { // Ruta Detail para DetailView
            DetailView(navController)
        }
    }
}