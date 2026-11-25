package com.example.ut2_8.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ut2_8.views.ArtistsView
import com.example.ut2_8.views.ContentHomeView
import com.example.ut2_8.views.MyAppView
import com.example.ut2_8.views.PremiumView
import com.example.ut2_8.views.SearchView

// Paso 7: Enumerado con los identificadores de ruta
enum class NavView {
    Home,
    Artists,
    Search,
    MyApp,
    Premium
}

// Paso 8: Mapa de navegación que asocia cada ruta con su vista Composable
@Composable
fun MiMusicaNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavView.Home.name
    ) {
        composable(NavView.Home.name) { ContentHomeView() }
        composable(NavView.Artists.name) { ArtistsView() }
        composable(NavView.Search.name) { SearchView() }
        composable(NavView.MyApp.name) { MyAppView() }
        composable(NavView.Premium.name) { PremiumView() }
    }
}