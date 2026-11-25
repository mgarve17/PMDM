package com.example.ut2_3.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ut2_3.views.DetailView
import com.example.ut2_3.views.HomeView

@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Home"
    ) {
        composable(route = "Home") {
            HomeView(navController)
        }
        composable(
            route = "Detail/{id}/{user}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType },
                navArgument("user") { type = NavType.StringType }
            )
        ) {
            val num = it.arguments?.getInt("id") ?: 0
            val usuario = it.arguments?.getString("user") ?: "Usuario desconocido"
            DetailView(navController, num, usuario)
        }
    }
}