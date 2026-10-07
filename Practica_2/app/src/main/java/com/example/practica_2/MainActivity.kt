package com.example.practica_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.unit.dp
import com.example.practica_2.ui.theme.Practica_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica_2Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaVisorAnimales()
                }
            }
        }
    }
}

@Composable
fun PantallaVisorAnimales(){

    val animales = remember{

        listOf(
            Animal(nombre = "ciervo", idRecurso = R.drawable.ciervo),
            Animal(nombre = "corzo", idRecurso = R.drawable.corzo),
            Animal(nombre = "jabali", idRecurso = R.drawable.jabali),
            Animal(nombre = "lobo", idRecurso = R.drawable.lobo),
            Animal(nombre = "oso", idRecurso = R.drawable.oso),
            Animal(nombre = "rebeco", idRecurso = R.drawable.rebeco)
        )

    }

    //estados reactivos de la interfaz
    var animalSeleccionado by remember { mutableStateOf(animales.random()) }
    var textoComentario by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(animales){ animal ->
                Image(
                    painter = painterResource(id = animal.idRecurso),
                    contentDescription = animal.nombre,
                    contentScale = ContentScale.Crop,
                    modifier =  Modifier.size(width = 80.dp, 60.dp).clip(RoundedCornerShape(4.dp))
                        .clickable{animalSeleccionado = animal}
                )

            }
        }
        Spacer(modifier = Modifier.height(12.dp))

        Image(
            painter = painterResource( id = animalSeleccionado.idRecurso),
            contentDescription = animalSeleccionado.nombre,
            contentScale = ContentScale.Crop,
                    modifier = Modifier .fillMaxWidth().height(200.dp).clip(RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.height(12.dp))

        Column(
            modifier = Modifier.weight(1f).fillMaxWidth().verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            animales.forEach { animal ->
                Button(
                    onClick = {animalSeleccionado= animal},
                    modifier = Modifier.width(140.dp).height(40.dp)
                ) {
                    Text(text = animal.nombre)
                }
            }
        }
        Spacer(modifier = Modifier.height(12.dp))

        // --- Campo de entrada para comentario ---
        TextField(
            value = textoComentario,
            onValueChange = { textoComentario = it },
            placeholder = { Text("Comentario") },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(4.dp)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFE0E0E0),
                unfocusedContainerColor = Color(0xFFE0E0E0),
                disabledContainerColor = Color(0xFFE0E0E0)
            )
        )
    }
}

