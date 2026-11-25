package com.example.ut2_8.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.painterResource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.ui.res.vectorResource
import com.example.ut2_8.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

// 1ª VERSIÓN (Sobrecargada): Recibe un ImageVector (imagen vectorial)
@Composable
fun RowScope.BottomNavigationButton(
    icon: ImageVector,
    label: String,
    selected: Boolean = false,
    onClick: () -> Unit = {}
) {
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
        label = { Text(text = label) }
    )
}

// 2ª VERSIÓN (Sobrecargada): Recibe un Painter (imagen no vectorial / mapa de bits)
@Composable
fun RowScope.BottomNavigationButton(
    icon: Painter,
    label: String,
    selected: Boolean = false,
    onClick: () -> Unit = {}
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = {
            Icon(
                painter = icon,
                contentDescription = label,
                modifier = Modifier.size(24.dp),
                // Color.Unspecified mantiene los colores originales de un icono PNG
                tint = Color.Unspecified
            )
        },
        label = { Text(text = label) }
    )
}

// Barra inferior con los 5 botones de la aplicación
@Composable
fun BottomNavigationBar() {
    NavigationBar {
        BottomNavigationButton(
            icon = Icons.Filled.Home,
            label = "Home",
            selected = true
        )
        BottomNavigationButton(
            icon = ImageVector.vectorResource(R.drawable.ic_queue_music),
            label = "Artists"
        )
        BottomNavigationButton(
            icon = Icons.Filled.Search,
            label = "Search"
        )
        BottomNavigationButton(
            icon = Icons.Filled.Person,
            label = "MyApp"
        )
        BottomNavigationButton(
            icon = painterResource(id = R.drawable.premium_png),
            label = "Premium"
        )
    }
}