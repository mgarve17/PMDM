package com.example.examenut1_maya

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import com.example.examenut1_maya.ui.theme.CafeTema
import com.example.examenut1_maya.ui.theme.ExamenUT1_MayaTheme
import com.example.examenut1_maya.ui.theme.TipoCafe

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamenUT1_MayaTheme {

                Surface() {
                    pantalla()
                }

            }
        }
    }
}

@Composable
fun pantalla(){

    var CategoriaActual by remember{ mutableStateOf(CafeTema.EXPRESSOS) }
    var listaCafes by remember{ mutableStateOf(value = CategoriaActual.imagenes)}
    var CafeSeleccionado by remember{ mutableStateOf(CategoriaActual.imagenes.first())}
    var nombreCliente by remember { mutableStateOf("") }
    var notasPedido by remember { mutableStateOf("") }
    var ticket by remember {  mutableStateOf("" )}

    var colorFondo by remember { mutableStateOf(Color(0xFF1E1E1E)) }
    //val scrollVerticalState = rememberScrollState()


Box(
    modifier = Modifier
        .fillMaxSize()
        .background(CategoriaActual.backgroundColor)
){

    Column(
        modifier = Modifier
            .fillMaxSize().padding(16.dp).verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text =  "BOUTIQUE DEL CAFÉ",
            style = MaterialTheme.typography.titleMedium,
            color = CategoriaActual.colorAcento,

        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {




            Image(
                painter = painterResource(id = CafeSeleccionado.idRecurso),
                contentDescription = CafeSeleccionado.descripcion,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            FloatingActionButton(
                onClick = {

                    Log.d("boton me gusta", "Me gusta pulsado para: ${CafeSeleccionado.nombre}")

                },
                containerColor = CategoriaActual.colorAcento,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Me gusta",
                    tint = Color.Red,

                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Button(onClick = {CategoriaActual = CafeTema.EXPRESSOS},
                colors = ButtonDefaults.buttonColors(CafeTema.EXPRESSOS.colorAcento))
            {

                Text("Expressos")
            }

            Button(onClick = { CategoriaActual = CafeTema.BEBIDASCONLECHE},
                colors = ButtonDefaults.buttonColors(CafeTema.BEBIDASCONLECHE.colorAcento))
            {

                Text("Leche")
            }

            Button(onClick = {CategoriaActual = CafeTema.CAFESAUTOR},

                colors = ButtonDefaults.buttonColors(CafeTema.CAFESAUTOR.colorAcento))
            {

                Text("Autor")
            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(12.dp))
        {

            for (cafe in listaCafes) {
                Surface(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape),
                    shadowElevation = 4.dp,
                    onClick = {
                        CafeSeleccionado = cafe

                    }
                ) {

                    Image(
                        painter = painterResource(id = cafe.idRecurso),
                        contentDescription = cafe.nombre,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }

        Text(
            text =  "Personaliza tu pedido",
            style = MaterialTheme.typography.titleMedium,
            color = Color.White
        )

        OutlinedTextField(
            value = nombreCliente,
            onValueChange = {nombreCliente = it},
            label= {Text("Nombre del cliente")},
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = notasPedido,
            onValueChange = {notasPedido = it},
            label= {Text("Añade una nota (ej. descafinado)")},
            modifier = Modifier.fillMaxWidth()
        )

        Row(

            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

           OutlinedButton(onClick = {},
                colors = ButtonDefaults.outlinedButtonColors(CategoriaActual.colorAcento))
            {

                Text("limpiar")
            }

            FilledTonalButton(onClick = {},
                colors = ButtonDefaults.buttonColors(CategoriaActual.colorAcento))
            {
                Text("Realizar pedido")
            }
        }



    }
}


}