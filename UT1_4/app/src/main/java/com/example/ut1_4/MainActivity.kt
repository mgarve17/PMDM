package com.example.ut1_4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ut1_4.ui.theme.UT1_4Theme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            UT1_4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content()
                }
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

    Column(modifier = Modifier.fillMaxSize()){

        Area1(modifier = Modifier.weight(0.5f))
        Area2()
        Area3(modifier = Modifier.weight(0.2f))
        Area4(modifier = Modifier.weight(0.1f))
    }

}


@Composable
fun Area1(modifier: Modifier = Modifier){

    Box(
        modifier = modifier.fillMaxWidth().background(Color(0xFFFFEB3B)).padding(10.dp),
        contentAlignment = Alignment.Center

    ){}
}


@Composable
fun ColumnScope.Area2(){

    Row(

        modifier = Modifier.fillMaxWidth().weight(0.2f).background(Color(0xFFFFF176)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){

        Text(text = "Texto1",color = Color.Black)
        Text(text = "Texto2",color = Color.Black)
    }

}

@Composable
fun Area3(modifier: Modifier = Modifier){

    Row(

        modifier = modifier.fillMaxWidth().background(Color(0xFFFFF8A4)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Text(text = "Área 3:", color = Color.Black)
    }

}

@Composable
fun Area4(modifier: Modifier = Modifier){

    Row(

        modifier = modifier.fillMaxWidth().background(Color(0xFFFFFDE7)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "Área 4", color = Color.Black)
    }
}

@Composable
fun Imagen1(){

    Image(

        painter
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UT1_4Theme {
        Greeting("Android")
    }
}