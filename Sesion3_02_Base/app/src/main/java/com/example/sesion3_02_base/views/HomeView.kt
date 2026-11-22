package com.example.sesion3_02_base.views

import android.content.Intent
import android.net.Uri
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun HomeView() {
    // Estados para los TextFields
    var url by remember { mutableStateOf("") }
    var latitude by remember { mutableStateOf("") }
    var longitude by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var context = LocalContext.current

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp) // Espacio entre componentes
        ) {
            // TextField para la URL
            TextField(
                value = url,
                onValueChange = { url = it },
                label = { Text("Introduce la URL") },
                modifier = Modifier.fillMaxWidth()
            )

            // Botón VER WEB
            Button(
                onClick = {
                    if (url.isBlank()){
                        Toast.makeText(
                            context, "por favor, introduce una URL.",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        if (!Patterns.WEB_URL.matcher(url).matches()){
                            Toast.makeText(
                                context, "la URL no tiene un formato válido",
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            try {
                                val intent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse(url))
                                context.startActivity(intent)
                            } catch ( e: Exception){

                                Toast.makeText(
                                    context, "No se pudo abrir la URL",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("VER WEB")
            }

            // TextField para la latitud
            TextField(
                value = latitude,
                onValueChange = { latitude = it },
                label = { Text("Introduce la Latitud") },
                modifier = Modifier.fillMaxWidth()
            )

            // TextField para la longitud
            TextField(
                value = longitude,
                onValueChange = { longitude = it },
                label = { Text("Introduce la Longitud") },
                modifier = Modifier.fillMaxWidth()
            )

            // Botón VER MAP
            Button(
                onClick = {
                    try{
                        val lat = latitude.toDoubleOrNull()
                        val lon = longitude.toDoubleOrNull()
                        //validar lat y lon
                        if (lat == null || lon == null
                            || lat !in -90.0 .. 90.0 || lon !in -180.0 .. 180.0){

                            Toast.makeText(
                                context,
                                "Pon bien los valores coño",
                                Toast.LENGTH_LONG

                            ).show()
                        } else {

                            val geoUri = "geo:$lat,$lon? z=15.0"
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))
                            context.startActivity(intent)
                        }
                    }catch (e: Exception){
                        Toast.makeText(
                            context,"error al intentar mostrar el mapa",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("VER MAP")
            }

            // TextField para el mensaje
            TextField(
                value = message,
                onValueChange = { message = it },
                label = { Text("Escribe un mensaje") },
                modifier = Modifier.fillMaxWidth()
            )

            // TextField para el número de teléfono
            TextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("Escribe un número de teléfono") },
                modifier = Modifier.fillMaxWidth()
            )

            // Botón ENVIAR A
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("smsto:$phoneNumber")
                        putExtra("sms_body",message)
                    }
                    context.startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("ENVIAR A")
            }

            // Botón COMPARTIR
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, message)
                    }
                    val chooser= Intent.createChooser(intent, "elige una aplicacion para compartir")
                    context.startActivity(chooser)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("COMPARTIR")
            }
        }
    }
}
