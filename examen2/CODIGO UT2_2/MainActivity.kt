package com.example.ut2_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AppEspacialScreen()
            }
        }
    }
}

// Modelo de datos para los elementos de nuestra lista
data class ElementoEspacial(val id: Int, val titulo: String, val descripcion: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppEspacialScreen() {
    // 1. Variable de estado para el tema
    var colorTema by remember { mutableStateOf(Color.Red) }

    // 2. Elegir el fondo dinámicamente con iconos del sistema seguros
    val fondoActual = when (colorTema) {
        Color.Red -> android.R.drawable.ic_menu_compass
        Color.Blue -> android.R.drawable.ic_menu_gallery
        else -> android.R.drawable.ic_menu_view
    }

    // Datos de ejemplo para la lista desplazable con Cards
    val listaElementos = listOf(
        ElementoEspacial(1, "Nebulosa de Orión", "Una nube de polvo y gas interestelar."),
        ElementoEspacial(2, "Estrella de Neutrones", "El remanente de una estrella supergigante."),
        ElementoEspacial(3, "Galaxia de Andrómeda", "Galaxia espiral vecina a la Vía Láctea."),
        ElementoEspacial(4, "Agujero Negro Supermasivo", "Región del espacio con un campo gravitatorio extremo.")
    )

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorTema.copy(alpha = 0.8f))
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Explorador Espacial",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )

                Row {
                    Button(onClick = { colorTema = Color.Red }, colors = ButtonDefaults.buttonColors(containerColor = Color.Red)) {
                        Text("Rojo")
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Button(onClick = { colorTema = Color.Blue }, colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)) {
                        Text("Azul")
                    }
                }
            }
        }
    ) { innerPadding ->
        // Aplicamos el innerPadding aquí para que el Box ocupe el espacio correcto debajo de la barra
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Imagen de fondo en pantalla completa
            Image(
                painter = painterResource(id = fondoActual),
                contentDescription = "Fondo del espacio",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            // Lista desplazable (LazyColumn) con tarjetas (Card)
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(listaElementos) { elemento ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Black.copy(alpha = 0.75f)
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = elemento.titulo,
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = elemento.descripcion,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.LightGray
                            )
                        }
                    }
                }
            }
        }
    }
}