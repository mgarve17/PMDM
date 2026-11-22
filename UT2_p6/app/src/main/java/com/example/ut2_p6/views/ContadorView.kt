package com.example.ut2_p6.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ut2_p6.ViewModels.ContadorViewModel

@Composable
fun ContadorView(viewModel: ContadorViewModel) {
    // Variable observadora: se actualiza automáticamente cuando cambia en el ViewModel
    val contador: Int by viewModel.contador.observeAsState(initial = 0)

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.add() }, // Llamamos a la función add() del ViewModel
                containerColor = Color.Blue,
                contentColor = Color.White
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Incrementar"
                )
            }
        }
    ) { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = innerPadding)
        ) {
            Text(
                text = contador.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )
        }
    }
}