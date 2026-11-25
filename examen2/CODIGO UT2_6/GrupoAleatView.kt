package com.example.ut2_6.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ut2_6.viewmodels.GrupoAleatViewModel

@Composable
fun GrupoAleatView(viewModel: GrupoAleatViewModel) {
    // 1. Declaramos la variable observadora para la lista de números
    val listaNumeros: List<Int> by viewModel.grupoAleatNumbers.observeAsState(initial = emptyList())

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (listaNumeros.isEmpty()) {
            Text(text = "Grupo de trabajo", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        } else {
            // 2. Pasamos la lista al componente que pinta los números
            GrupoNumbers(numbers = listaNumeros)
        }

        // 3. Pasamos la función generateGrupoNumbers al onClick del botón Generar
        Button(onClick = { viewModel.generateGrupoNumbers() }) {
            Text(text = "Generar", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun GrupoNumbers(numbers: List<Int>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(numbers) { number ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .size(48.dp)
                    .background(Color.Red, CircleShape)
            ) {
                Text(
                    text = number.toString(),
                    color = Color.White,
                    fontSize = 24.sp
                )
            }
        }
    }
}