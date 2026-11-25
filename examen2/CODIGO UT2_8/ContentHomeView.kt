    package com.example.ut2_8.views

import android.os.Build
import androidx.annotation.RequiresApi
// Borra esta línea:
// import androidx.compose.foundation.R

// Y cámbiala por la importación correcta de tu paquete:
import com.example.ut2_8.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.ut2_8.data.audiosMusicalesExt
import com.example.ut2_8.data.reflexiones
import com.example.ut2_8.model.Reflexion
import java.time.LocalDate
import java.time.temporal.ChronoUnit

    @RequiresApi(Build.VERSION_CODES.O)
fun obtenerReflexionDelDia(fechaActual: LocalDate = LocalDate.now()): Reflexion {
    val fechaInicio = LocalDate.of(2026, 10, 27)
    val fechaFin = LocalDate.of(2026, 11, 5)

    // Comprobamos si la fecha actual está entre el 28/10/2026 y el 06/11/2026 (ambos incluidos)
    return if (fechaActual in fechaInicio..fechaFin) {
        // Calculamos la diferencia de días (dará un número del 0 al 9)
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
@Composable
fun ContentHomeView() {
    val reflexionHoy = obtenerReflexionDelDia()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
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

        // Añadimos el nuevo componente debajo de la Frase del día
        AudioMasReciente()
    }
}
    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    fun AudioMasReciente() {
        // Obtenemos el audio más reciente de la lista con URLs
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
                // GlideImage descarga y pinta la imagen desde Internet
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