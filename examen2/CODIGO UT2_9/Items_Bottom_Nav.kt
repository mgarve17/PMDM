package com.example.ut2_8.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.ut2_8.navigation.NavView

sealed class Items_Bottom_Nav(
    val icono: ImageVector,
    val texto: String,
    val ruta: String
) {
    object Item_bottom_nav_home : Items_Bottom_Nav(
        Icons.Filled.Home, "Home", NavView.Home.name
    )
    object Item_bottom_nav_artists : Items_Bottom_Nav(
        Icons.Filled.List, "Artists", NavView.Artists.name
    )
    object Item_bottom_nav_search : Items_Bottom_Nav(
        Icons.Filled.Search, "Search", NavView.Search.name
    )
    object Item_bottom_nav_myapp : Items_Bottom_Nav(
        Icons.Filled.Person, "MyApp", NavView.MyApp.name
    )
    object Item_bottom_nav_premium : Items_Bottom_Nav(
        Icons.Filled.Star, "Premium", NavView.Premium.name
    )
}