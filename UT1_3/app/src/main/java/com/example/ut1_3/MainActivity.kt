package com.example.ut1_3
import androidx.compose.material3.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ut1_3.ui.theme.UT1_3Theme
import android.widget.Button
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton

import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Content()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun Content(){

    Column(
        modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.Center).verticalScroll(
            rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally) { }
}

@Composable

fun BotonNormal1(){

    Button(onClick = {/*TODO*/},
        enabled=false,
        modifier = Modifier.padding(8.dp).fillMaxWidth(0.8f).wrapContentWidth(Alignment.Start))
    {
        Text(text="Boton normal 1",
            fontSize = 20.sp,
            modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun BotonNormal2(){

    Button( onClick = {Log.d("PRUEBAS","pulsado boton normal 2")},
        colors = ButtonDefaults.buttonColors(containerColor = Color.Red,
            contentColor = Color.White)
        ) {

        Text(text = "Boton Normal 2",
            fontSize = 20.sp)
    }
}

@Composable
fun BotonTonal3(s: String, sp: TextUnit){

    FilledTonalButton(onClick = {
        Log.d("PRUEBAS", "has pulsado el boton tonal") }) {

        Text(text=s,
            fontSize = sp)
    }
}

@Composable
fun BotonTexto4(s: String, sp: TextUnit){

    TextButton( onClick = { Log.d("PRUEBAS", "has pulsado el boton de texto")}) {

        Text(text=s, fontSize = sp)
    }
}

@Composable
fun BotonContorno5(s: String, sp: TextUnit){


    OutlinedButton( onClick = {Log.d("PRUEBAS", "Has pulsado el boton contorno")},
        border = BorderStroke(width = 2.dp, color= Color.Blue)
        ) {

        Text(text = s,
            fontSize = sp)
    }
}

@Composable
fun BotonElevado6(s: String, sp: TextUnit){

    ElevatedButton(onClick = {Log.d("PRUEBAS", "has pulsado el boton elevado")}) {

        Text(text = s,
            fontSize = sp)
    }
}

@Composable
fun Espacio(dp: Dp){//función para espaciar verticalmente los botones

    Spacer(modifier = Modifier.height(dp))
}
 @Composable
 fun BotonNormalIcono7(){

     IconButton( onClick = {/*TODO*/}) {

        Icon(
            Icons.Filled.AccountCircle,
            contentDescription = "icono de favoritos",
            tint = Color.Red,
            modifier = Modifier.size(20.dp)
        )
         Spacer(modifier = Modifier.width(4.dp))
         Text(text="Favoritos", fontSize = 20.sp)
     }
 }

@Composable
fun Fila(){

    Row(){
        BotonIcono(Icons.Filled.Build, "Icono Configurar")
        Espacio(4.dp)
        BotonIcono(Icons.Filled.AccountCircle, "cuenta de usuario")
        Espacio(4.dp)
        BotonIcono(Icons.Filled.Email, "Mail de usuario")
        Espacio(4.dp)
        BotonIcono(Icons.Filled.Phone, "Telefono")
        Espacio(8.dp)
        BotonIcono(Icons.Filled.Info, "Informacion")
    }
}
@Composable
fun BotonIcono(build: ImageVector, s: String){

    IconButton( onClick = {Log.d("PRUEBAS", "Has pulsado $s")},
        modifier = Modifier.size(50.dp)
    ) {

        Icon(build, contentDescription = s, tint = Color.red,
            modifier = Modifier.fillMaxSize())
    }
}


@Composable
fun BotonNormal(){

    var n by remember { mutableIntStateOf(value = 0) }

    Button(onClick = {n++
    Log.d("TAG_BIN", "se ha pulsado $n veces")},
        contentPadding = PaddingValues(top= 20.dp, bottom = 20.dp),
        modifier = Modifier.padding(16.dp).fillMaxWidth(0.75f),

        colors= ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary
        ),
        shape = MaterialTheme.shapes.extraLarge,
        ){
        Text(text = "Botón normal",
            fontSize = 30.sp)

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UT1_3Theme {
        Greeting("Android")
    }
}