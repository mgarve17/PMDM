package com.example.app1_1

import android.R
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app1_1.ui.theme.App1_1Theme
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App1_1Theme {

                Content()

// llamar al boton saludar
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//
//                    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
//
//                        BotonSaludar()
//                    }
                //}
                }

            }
        }
    }


@Composable //tag para mostrar cosas por pantalla
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun Content(){

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background)
    {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize().padding(16.dp)
        ){

            TextoRecibido("Texto dinámico alineado a la derecha")
            //TextoPersonalizado()
        }
    }

}

@Composable
fun TextoRecibido(mensaje: String){

    Text(
        text = mensaje,

        //propiedades
        fontSize = 20.sp,
        color = Color(0xFF2E7D32), // Color verde
        textAlign = TextAlign.End,//alinear a la derecha

        //modificadores solicitados en cadena
        modifier = Modifier
            .fillMaxWidth() // 1. Ocupar todo el ancho
            .background(Color(0xFFE8F5E9))// 2. Color de fondo verd claro
                .clickable { // 4. Detectar toque
            Log.d("TEXTO_CLICK", "¡Has pulsado sobre el texto!")
        }
            .padding(16.dp)
    )
}

@Composable
fun TextoPersonalizado(){

    Text(

        text = "Jetpack Compose permite estilizar textos con gran\n" +
                "detalle. Esta frase larga sirve para verificar cómo funcionan el salto\n" +
                "de línea automático y el recorte por overflow",

        //tamaño y colores
        fontSize = 20.sp,
        color = Color(0xFFFF5722),

        //tipografia
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.SansSerif,

        //espacios y alineación
        lineHeight = 28.sp,
        letterSpacing = 1.5.sp,
        textAlign = TextAlign.Center,

        //saltos de linea, límites y recoertes

        softWrap = true,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,

        //Medición en segundo plano

        onTextLayout = { textLayoutResult ->
            Log.d("TEXTO_LAYOUT", "Líneas renderizadas: ${textLayoutResult.lineCount}")
            Log.d("TEXTO_LAYOUT", "Ha sido recortado: ${textLayoutResult.hasVisualOverflow}")
        },

        //forzar un ancho para comprobar el salto y el recorte
        modifier = Modifier.width(280.dp)

    )
}

@Composable
fun BotonSaludar(modifier: Modifier = Modifier){//crear boton
   Button(//accion al clicar
       onClick = {Log.d("MI_APP","Bienvenido a Android!")},

       //propiedades del boton


       modifier = modifier

   ) {

       Text(text = "SALUDAR")//texto del botón
   }

}

@Preview(showBackground = true)//para ver como quedan las movidas
@Composable
fun GreetingPreview() {
    App1_1Theme {
        Greeting("Android")
    }
}