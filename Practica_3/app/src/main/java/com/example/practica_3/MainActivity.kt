package com.example.practica_3

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practica_3.ui.theme.Practica_3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                PracticaParquesScreen()
            }
        }
    }
}

@Composable
fun PracticaParquesScreen(){

    //variables para los estados de la app, definir parametros para mostrar algo en especifico
    //o dejar value vacio para que no comience con nada
    var parqueSeleccionado by remember{ mutableStateOf(ParqueTema.DISNEY) }
    var imagenPrincipal by remember{mutableStateOf(parqueSeleccionado.imagenes.first())}

    var nombreVisitante by remember { mutableStateOf("") }
    var comentario by remember { mutableStateOf("") }

    var mensajeError by remember { mutableStateOf("") }
    var ticketPublicado by remember { mutableStateOf<String?>(null) }

    //funcion para actualizar el parque y cambiar la imagen principal
    fun cambiarParque(nuevoParque: ParqueTema){

        parqueSeleccionado = nuevoParque
        imagenPrincipal = nuevoParque.imagenes.first()
    }

    //variable que junta las fotos del parque seleccionado con las genericas
    val galeria = parqueSeleccionado.imagenes + imagenesGenericas

    Box(
        //cambiar el color del fondo para que utilice el que esta definido en los parques
        modifier = Modifier.fillMaxSize().background(parqueSeleccionado.backgroundColor)
    ){
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp).verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            //CABECERA
            Box(
                modifier= Modifier.fillMaxWidth().height(220.dp).clip(RoundedCornerShape(16.dp))
            ){

                Image(
                    painter = painterResource(id = imagenPrincipal.imageRes),
                    contentDescription = imagenPrincipal.titulo,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                FloatingActionButton(
                    onClick = {

                        Log.d("PracticaCompose", "Me gusta pulsado para: ${imagenPrincipal.titulo}")
                    },
                    containerColor = Color.White,
                    modifier = Modifier.align(Alignment.BottomEnd).padding(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite ,
                        contentDescription = "Me gusta",
                        tint = Color.Red
                    )
                }
            }
        }
    }
}



