package com.example.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp

class BottomNavigationComponents {

    @Composable
    fun RowScope.BottomNavigationButton(

        icon: ImageVector,
        label: String,
        selected: Boolean = false,
        onClick: () -> Unit = {}

    ){

        NavigationBarItem(
            selected = selected,
            onClick = onClick,
            icon = {

                Icon(
                   imageVector = icon,
                    contentDescription = label,
                    modifier = Modifier.size(24.dp)
                )
            },
            label = {Text(text = label)}
        )
    }

    @Composable
    fun RowScope.BottomNavigationButton(

        icon: Painter,
        label: String,
        selected: Boolean = false,
        onClick: () -> Unit = {}
    ){

        NavigationBarItem(
            selected = selected,
            onClick = onClick,
            icon = {
                Icon(
                    painter = icon,
                    contentDescription = label,
                    modifier = Modifier.size(24.dp),
                    tint = Color.Unspecified
                )
            },
            label = {Text(text = label)}
        )

    }

    @Composable
    fun BottomNavigationBar(){

        NavigationBar {

            BottomNavigationButton(
                icon = Icons.Filled.Home,
                label = "Home",
                selected = true
            )
            BottomNavigationButton(
                icon = Icons.Filled.List,
                label = "Artist"
            )
            BottomNavigationButton(
                icon = Icons.Filled.Search,
                label = "Artist"
            )
            BottomNavigationButton(
                icon = Icons.Filled.Person,
                label = "MyApp"
            )
            BottomNavigationButton(
                icon = Icons.Filled.Star,
                label = "Premium"
            )
        }
    }
}