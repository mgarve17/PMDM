package com.example.practica4_ut2.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.practica4_ut2.data.Artista
import  com.example.practica4_ut2.data.RepositorioArtistas

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun DetailView(
    navController: NavController,
    idArtista: Int
) {
    // Ejercicio 5: Buscar los datos del artista correspondiente al id recibido
    val artista = RepositorioArtistas.listaArtistas.find { it.id == idArtista }
        ?: RepositorioArtistas.listaArtistas[1]

    Scaffold(
        topBar = {
            // Ejercicio 6: TopBar con botón para navegar hacia atrás a la pantalla principal
            TopAppBar(
                title = {
                    Text(
                        text = artista.nombre,
                        color = Color(0xFF3B5284)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver atrás",
                            tint = Color(0xFF3B5284)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFD6E2FF)
                )
            )
        }
    ) { paddingValues ->
        // Ejercicio 3: Diseño de DetailView según la distribución de la práctica
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFD6E2FF))
                .verticalScroll(rememberScrollState())
        ) {
            // Imagen superior ocupando todo el ancho
            GlideImage(
                model = artista.imagenUrl,
                contentDescription = artista.nombre,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(320.dp)
            )

            // Bloque inferior con los datos del artista y su biografía
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    text = "Artista: ${artista.nombre}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Ciudad: ${artista.ciudad}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Estilo musical: ${artista.estilo}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Año de inicio: ${artista.anioInicio}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = artista.biografia,
                    fontStyle = FontStyle.Italic,
                    fontSize = 15.sp,
                    lineHeight = 22.sp,
                    color = Color.Black
                )
            }
        }
    }
}