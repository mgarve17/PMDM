package com.example.ut2_10.views

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun HomeView(){

    Scaffold(
        topBar = {TopMenuBar() },
        content = {paddingValues ->
            ContentHomeView(paddingValues)
        }
    )
}

@Composable
fun ContentHomeView(paddingValues: PaddingValues){

    Box(
        modifier = Modifier.padding(paddingValues).fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
         Text(text = "Contenido", fontSize = 30.sp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopMenuBar(){

    var showMenu by remember { mutableStateOf(false) }

    TopAppBar(
        title = {Text(text = "Sesion 2-10", color = Color.White) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Blue
        ),
        //icono de navegacion a la izquierda

        navigationIcon = {
            IconButton( onClick = { Log.d("prueba","Pulsando navigationIcon")}) {

                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menú de navegación",
                    tint = Color.Black
                )
            }
        },

        //botones de acción a la derecha

        actions = {
            IconButton(onClick = { Log.d("prueba","Pulsando buscar")}) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Buscar",
                    tint = Color.White
                )
            }
            IconButton(onClick =  {Log.d("prueba","Pulsando Ajustes")}) {
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

            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { }
            ) {
                DropdownMenuItem(
                    text = {Text("PRevisualizar")},
                    onClick = {Log.d("PRUEBA", "seleccionado previsualizar")
                                showMenu=false}
                )
            }
        },
    )

}