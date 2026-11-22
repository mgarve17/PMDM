package com.example.ut3_01.views

import android.R
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.combineTransform
import kotlinx.coroutines.launch

@Composable
fun HomeView(){

    //variable de estado para el color de fondo de pantalla
    var backgroundColor by remember { mutableStateOf(value = Color.Blue) }
    //variable de estado del texto informativo sobre  la descarga
    var donwloadText by remember{mutableStateOf(value = "Descarga no realizada")}
    //variable de estado del texto informativo sobre petición de API
    var apiText by remember { mutableStateOf(value = "sin consultar API") }
    //variable de estado que deshabilita la función de descarga si ya hay una en procesp
    var isDownloading by remember { mutableStateOf(false) }
    //variable de estado que funciona como contador para descargas
    var timerValue by remember { mutableStateOf(60) }
    //variable de estado para algo del contador y que no se duplique no sé tío
    var timerJob by remember { mutableStateOf<Job?>(null) }
    //variable de ??? que hace ???
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize().background(backgroundColor),
        contentAlignment = Alignment.Center
    )    {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            //boton que cambia entre el fondo rojo y el azul
            Button( onClick = {
                backgroundColor= if (backgroundColor == Color.Blue) Color.Red else
                    Color.Blue
            }) {
                Text("cambiar Color")
            }

            //botón descargar
            Button(onClick = {
                coroutineScope.launch {
                    isDownloading = true //deshabilitar el botón
                    Log.d("Corrutina","Iniciada nueva descarga")
                    donwloadText = "Descargando vídeo"
                    delay(10000L)
                    donwloadText = "Terminada la descarga"
                    Log.d("Corrutina","Descarga finalizada")
                    isDownloading = false;
                }

            },
                //solo está activo el botón si no está descargando
                enabled = !isDownloading

            ) {
                Text("DESCARGAR")
            }
            Text(text = donwloadText, color = Color.White)

            Button(onClick = {
                coroutineScope.launch {
                    apiText = "Consultado API"
                    delay(5000L)
                    apiText = "Respuesta de API recibida"
                }
            }) {
                Text("PETICIÓN API")
            }
            Text(text = apiText, color = Color.White)

            //Botón contador
            Button(onClick = {
                coroutineScope.launch {
                    //cancelar la corrutina previa si existe
                    timerJob?.cancel()
                    timerJob = coroutineScope.launch {
                        timerValue = 60 //iniciar en 60
                        while (timerValue > 0){
                            delay(1000L) //esperar un segundo
                            timerValue--

                    }

                    }
                }
            }) {
                Text("CONTADOR")
            }



            Text(
                text = timerValue.toString(),
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White

            )

            Button(onClick = {
                coroutineScope.launch {
                    timerJob?.cancel()
                    //timerValue = 60
                }
            }) {
                Text("DETENER")
            }
        }
    }
}