package com.example.practica_1

import android.R.attr.contentDescription
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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.example.practica_1.ui.theme.Practica_1Theme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

private const val TAG = "DIARIO_ASTRONAUTA"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
         DiarioAstroturistaApp()
        }
    }
}

@Composable
fun DiarioAstroturistaApp(){
//1. DECLARACION DE VARIABLES DE ESTADO
    var nombreExplorador by remember{ mutableStateOf("") }
    var entradaRegistro by remember{mutableStateOf("")}
    var colorTema by remember { mutableStateOf(Color.Gray) }

    //estado para cambiar la imagen de fondo
    var fondoActual by remember { mutableStateOf(R.drawable.fondo_nebulosa) }

    Box(modifier = Modifier.fillMaxSize()){

        Image(
            painter = painterResource(id = fondoActual),
            contentDescription = "Fondo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize().padding(16.dp).verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){

            //Encabezado estilizado con el color del sistema
            Box(modifier = Modifier.fillMaxWidth().background(colorTema).padding(8.dp)){

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icono_casco),
                        contentDescription = "Icono Diario",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text =  "Diario de Mision - Explorador: $nombreExplorador",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )
                }

            }

            //campo para el nombre
            OutlinedTextField(
                value = nombreExplorador,
                onValueChange = {nombreExplorador = it},
                label= {Text("Nombre del Explorador")},
                modifier = Modifier.fillMaxWidth()
            )
            //campo para entradaRegistro
            OutlinedTextField(
                value = entradaRegistro,
                onValueChange = {entradaRegistro= it},
                label = {Text("Entrada de registro: (150 caracteres máx)")},
                modifier = Modifier.fillMaxWidth()
            )
            //Instanciar el boton
            BotonPersonalizado(texto = "Publicar Registro",
                onClick = {
                    Log.d(TAG, "Registro publicado por el explorador $nombreExplorador")
                }
            )

            //Texto con medicion en el logcat
            Text(
                text = "Resumen del registro: \n$entradaRegistro",
                modifier = Modifier.fillMaxWidth().background(Color.Black).padding(8.dp),
                color = Color.White,
                onTextLayout = { textLayoutResult ->
                    val lineas = textLayoutResult.lineCount
                    val desbordamiento = textLayoutResult.hasVisualOverflow
                    Log.d(TAG, "Líneas: $lineas | Desbordamiento: $desbordamiento")
                }
            )

            Text(
                text = "Cambia el tema y el fondo de la interfaz:",
                color = Color.White
            )


            //botones para cambiar el color tema e imagen
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        colorTema = Color.Red
                        fondoActual = R.drawable.fondo_nebulosa
                    },
                    colors = ButtonDefaults.buttonColors(Color.Red)
                ) {

                    Text("Nebulosa")
                }

                Button(
                    onClick = {
                        colorTema = Color.Blue
                        fondoActual= R.drawable.fondo_arbol_estrellas
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                ) {
                    Text("Árbol")
                }

                Button(
                    onClick = {

                        colorTema = Color.DarkGray
                        fondoActual = R.drawable.fondo_via_lactea
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text("Vía Láctea", color = Color.Black)
                }
            }
        }

    }





}

@Composable
fun BotonPersonalizado(

    texto: String, onClick: () -> Unit

    ){

        Button(onClick = onClick, modifier = Modifier.fillMaxWidth()){

            Text(text = texto)
        }
    }
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Practica_1Theme {
        Greeting("Android")
    }
}