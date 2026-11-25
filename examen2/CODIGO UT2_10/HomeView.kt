package com.example.ut2_10.views

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun HomeView() {
    Scaffold(
        topBar = { TopMenuBar() },
        content = { paddingValues ->
            ContentHomeView(paddingValues)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopMenuBar() {
    // 1. Estado para controlar la visibilidad del menú desplegable
    var showMenu by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "Sesión 2-10", color = Color.White) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Blue
        ),
        // Icono de navegación a la izquierda (las 3 líneas horizontales)
        navigationIcon = {
            IconButton(onClick = { Log.d("PRUEBA", "Pulsado NavigationIcon") }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menú de navegación",
                    tint = Color.Black
                )
            }
        },
        // Botones de acción a la derecha (Buscar, Ajustes y Menú de 3 puntos)
        actions = {
            IconButton(onClick = { Log.d("PRUEBA", "Pulsado Buscar") }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Buscar",
                    tint = Color.White
                )
            }
            IconButton(onClick = { Log.d("PRUEBA", "Pulsado Ajustes") }) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Ajustes",
                    tint = Color.White
                )
            }
            IconButton(onClick = { showMenu = true }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Menú desplegable",
                    tint = Color.White
                )
            }
            // Menú desplegable
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Previsualizar") },
                    onClick = {
                        Log.d("PRUEBA", "seleccionado previsualizar")
                        showMenu = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("Compartir") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = "Compartir icono"
                        )
                    },
                    onClick = {
                        Log.d("PRUEBA", "seleccionado compartir")
                        showMenu = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("Copiar Enlace") },
                    onClick = {
                        Log.d("PRUEBA", "seleccionado copiar enlace")
                        showMenu = false
                    }
                )
                DropdownMenuItem(
                    text = { Text("Descargar") },
                    enabled = false, // Deshabilita esta opción
                    onClick = {
                        Log.d("PRUEBA", "seleccionado descargar")
                        showMenu = false
                    }
                )

                // Línea divisora por defecto
                HorizontalDivider()

                DropdownMenuItem(
                    text = { Text("Denunciar") },
                    onClick = {
                        Log.d("PRUEBA", "seleccionado denunciar")
                        showMenu = false
                    }
                )
            }
        }
    )
}

// Variables de estado añadidas al principio de ContentHomeView:

@Composable
fun ContentHomeView(paddingValues: PaddingValues) {
    var myText by remember { mutableStateOf("Texto de prueba") }
    // Estado para controlar el menú contextual del texto
    var showMenu by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    var inputText by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Envolvemos el Text y el DropdownMenu en un Box para que el menú salga justo debajo
        Box {
            Text(
                text = myText,
                fontSize = 30.sp,
                modifier = Modifier.combinedClickable(
                    onClick = { }, // Obligatorio ponerlo aunque quede vacío
                    onLongClick = {
                        showMenu = true // Se despliega al mantener pulsado
                    }
                )
            )

            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Borrar") },
                    onClick = {
                        showMenu = false
                        Log.d("MENU", "Opción Borrar seleccionada")
                    }
                )
                DropdownMenuItem(
                    text = { Text("Duplicar") },
                    onClick = {
                        showMenu = false
                        Log.d("MENU", "Opción Duplicar seleccionada")
                    }
                )
                DropdownMenuItem(
                    text = { Text("Editar") },
                    onClick = {
                        showMenu = false
                        Log.d("MENU", "Opción Editar seleccionada")
                        showDialog = true // Abre el cuadro de diálogo
                    }
                )
                DropdownMenuItem(
                    text = { Text("Asignar") },
                    onClick = {
                        showMenu = false
                        Log.d("MENU", "Opción Asignar seleccionada")
                    }
                )
            }
        }
    }
    // Si showDialog está a true, se muestra el cuadro de diálogo en pantalla
    if (showDialog) {
        AlertDialog(
            // Cuando se clica fuera del cuadro de diálogo
            onDismissRequest = { showDialog = false },
            title = { Text(text = "Editar texto") },
            text = {
                Column {
                    TextField(
                        // Variable de estado iniciada a ""
                        value = inputText,
                        onValueChange = { inputText = it },
                        label = { Text("Nuevo texto?") }
                    )
                }
            },
            // Definición del botón confirmar y acciones que realiza
            confirmButton = {
                TextButton(onClick = {
                    myText = inputText // Actualizar el texto principal
                    showDialog = false
                }) {
                    Text("Aceptar")
                }
            },
            // Definición del botón de cancelación y acciones
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            }
        )
    }
}