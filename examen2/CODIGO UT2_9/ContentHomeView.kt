package com.example.ut2_8.views

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.ut2_8.R
import com.example.ut2_8.data.audiosMusicalesExt
import com.example.ut2_8.data.reflexiones
import com.example.ut2_8.model.Encuesta
import com.example.ut2_8.model.Reflexion
import java.time.LocalDate
import java.time.temporal.ChronoUnit

@SuppressLint("NewApi")
fun obtenerReflexionDelDia(fechaActual: LocalDate = LocalDate.now()): Reflexion {
    val fechaInicio = LocalDate.of(2026, 10, 27)
    val fechaFin = LocalDate.of(2026, 11, 5)

    return if (fechaActual in fechaInicio..fechaFin) {
        val indice = ChronoUnit.DAYS.between(fechaInicio, fechaActual).toInt()
        reflexiones[indice]
    } else {
        Reflexion(
            frase = "NO HAY FRASE DEL DÍA",
            autor = "",
            fecha = fechaActual
        )
    }
}

@SuppressLint("NewApi")
@Composable
fun ContentHomeView() {
    val reflexionHoy = obtenerReflexionDelDia()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
    ) {
        Text(
            text = "Frase del día",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(12.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "\"${reflexionHoy.frase}\"",
                    fontStyle = FontStyle.Italic,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(8.dp))

                if (reflexionHoy.autor.isNotEmpty()) {
                    Text(
                        text = "- ${reflexionHoy.autor}",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.End,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        AudioMasReciente()

        Spacer(modifier = Modifier.height(16.dp))

        EncuestaSection()
    }
}

@SuppressLint("NewApi")
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AudioMasReciente() {
    val audioMasReciente = audiosMusicalesExt.maxBy { it.fecha }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Audio más reciente",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            GlideImage(
                model = audioMasReciente.urlImagen,
                contentDescription = "Imagen del audio más reciente",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                loading = placeholder(R.drawable.ic_queue_music),
                failure = placeholder(R.drawable.ic_premium_vector)
            )

            IconButton(
                onClick = { },
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.Center)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    )
            ) {
                Icon(
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = "Reproducir",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }

            Text(
                text = "${audioMasReciente.titulo} - ${audioMasReciente.artist}",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(Color.Yellow.copy(alpha = 0.7f))
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun EncuestaSection() {
    val context = LocalContext.current
    val encuestaActual = Encuesta.EncuestaHoy

    Column(modifier = Modifier.fillMaxWidth()) {
        var respuestaSeleccionada by remember { mutableStateOf<String?>(null) }

        Text(text = encuestaActual.pregunta, fontSize = 20.sp)

        encuestaActual.respuestas.forEach { respuesta ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (respuesta == respuestaSeleccionada),
                    onClick = {
                        respuestaSeleccionada = respuesta
                        Toast.makeText(
                            context,
                            "Has pulsado justo en el RadioButton de la respuesta $respuesta",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = respuesta)
            }
        }

        Button(
            onClick = {
                if (respuestaSeleccionada != null) {
                    val indice = encuestaActual.respuestas.indexOf(respuestaSeleccionada)
                    Toast.makeText(
                        context,
                        "Seleccionada: $respuestaSeleccionada (Índice: $indice)",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        context,
                        "No has seleccionado ninguna respuesta",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        ) {
            Text(text = "Enviar")
        }
    }
}