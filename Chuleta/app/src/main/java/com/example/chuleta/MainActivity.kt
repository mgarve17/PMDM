package com.example.chuleta

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    companion object {
        private const val TAG = "EXAMEN_PMDM_LOG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Estado global de la app (Tema, Parque seleccionado, Imagen actual, Formulario)
            var temaSeleccionado by remember { mutableStateOf("Disney") }
            var colorFondoApp by remember { mutableStateOf(Color(0xFFE3F2FD)) /* Azul claro */ }

            // Datos del formulario
            var nombreVisitante by remember { mutableStateOf("") }
            var comentarioExperiencia by remember { mutableStateOf("") }

            // Mensajes y resultados de validación
            var mensajeError by remember { mutableStateOf("") }
            var ticketPublicado by remember { mutableStateOf<Triple<String, String, String>?>(null) }

            // Definición de Parques y sus recursos (Data Classes inspiradas en las prácticas)
            val listaDisney = listOf(
                ItemParque(R.drawable.i1, "Castillo Disney", "Mágica atracción principal del reino encantado."),
                ItemParque(R.drawable.i2, "Atracción Espacial", "Montaña rusa ambientada en el espacio exterior."),
                ItemParque(R.drawable.i3, "Desfile Nocturno", "Espectáculo de luces y carrozas musicales.")
            )

            val listaPortAventura = listOf(
                ItemParque(R.drawable.i4, "Dragon Khan", "Icónica montaña rusa de ocho inversiones."),
                ItemParque(R.drawable.i5, "Shambhala", "Hypercoaster con caída vertiginosa."),
                ItemParque(R.drawable.i6, "Furius Baco", "Aceleración de 0 a 135 km/h en pocos segundos.")
            )

            val listaWarner = listOf(
                ItemParque(R.drawable.i7, "Gotham Stunt Track", "Emocionante coaster tematizada de villanos."),
                ItemParque(R.drawable.i8, "Superman La Atracción", "Vuela como el hombre de acero con caída libre."),
                ItemParque(R.drawable.i9, "Shadows of Arkham", "Montaña rusa invertida llena de adrenalina.")
            )

            // Imágenes genéricas comunes (i10 e i11)
            val imagenesGenericas = listOf(
                ItemParque(R.drawable.i10, "Zona de Comudas", "Área de descanso y restauración general."),
                ItemParque(R.drawable.i11, "Tienda de Recuerdos", "Merchandising oficial y souvenirs del parque.")
            )

            // Selección de la lista según el tema activo
            val parqueActualList = when (temaSeleccionado) {
                "Disney" -> listaDisney
                "P.Aventura" -> listaPortAventura
                else -> listaWarner
            }

            // Galería combinada (Parque actual + Genéricas)
            val galeriaCompleta = parqueActualList + imagenesGenericas

            // Estado de la imagen principal seleccionada (por defecto la primera del parque)
            var itemPrincipalSeleccionado by remember(temaSeleccionado) {
                mutableStateOf(parqueActualList.first())
            }

            // Scroll vertical general para toda la pantalla[cite: 1]
            val scrollVerticalState = rememberScrollState()

            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorFondoApp),
                color = colorFondoApp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollVerticalState)
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {

                    // ==========================================
                    // ÁREA 1: CABECERA DESTACADA (Box)[cite: 1]
                    // ==========================================
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp)
                            .clip(RoundedCornerShape(16.dp))
                    ) {
                        // Imagen de fondo ocupando todo el contenedor
                        Image(
                            painter = painterResource(id = itemPrincipalSeleccionado.imageRes),
                            contentDescription = itemPrincipalSeleccionado.titulo,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                        // Botón flotante en la esquina inferior derecha con icono de corazón
                        FloatingActionButton(
                            onClick = {
                                Log.d(TAG, "Botón Me gusta pulsado en la atracción: ${itemPrincipalSeleccionado.titulo}")
                            },
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(12.dp),
                            shape = CircleShape,
                            containerColor = MaterialColorHelper.getColorThemeAccent(temaSeleccionado)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "Me gusta",
                                tint = Color.White
                            )
                        }
                    }

                    // ==========================================
                    // ÁREA 2: SELECTOR TEMÁTICO (State y Button)[cite: 1]
                    // ==========================================
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        val botonesParques = listOf("Disney", "P.Aventura", "Warner")
                        botonesParques.forEach { parque ->
                            Button(
                                onClick = {
                                    temaSeleccionado = parque
                                    // Cambiar color de fondo de la app dinámicamente según el tema
                                    colorFondoApp = when (parque) {
                                        "Disney" -> Color(0xFFE3F2FD)      // Azul claro
                                        "P.Aventura" -> Color(0xFFFFFDE7)  // Amarillo claro
                                        else -> Color(0xFFFFEBEE)          // Rojo claro
                                    }
                                    Log.d(TAG, "Tema cambiado a: $parque")
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = if (temaSeleccionado == parque)
                                        MaterialColorHelper.getColorThemePrimary(parque)
                                    else Color.Gray
                                )
                            ) {
                                Text(text = parque, color = Color.White)
                            }
                        }
                    }

                    // ==========================================
                    // ÁREA 3: GALERÍA INTERACTIVA (Scroll Horizontal)[cite: 1, 3]
                    // ==========================================
                    Text(text = "Galería de imágenes:", style = MaterialTheme.typography.titleMedium)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        galeriaCompleta.forEach { item ->
                            // Miniaturas circulares clicables (70.dp)[cite: 1]
                            Surface(
                                modifier = Modifier
                                    .size(70.dp)
                                    .clip(CircleShape),
                                shadowElevation = 4.dp,
                                onClick = {
                                    itemPrincipalSeleccionado = item
                                    Log.d(TAG, "Miniatura seleccionada: ${item.titulo}")
                                }
                            ) {
                                Image(
                                    painter = painterResource(id = item.imageRes),
                                    contentDescription = item.titulo,
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                    }

                    // ==========================================
                    // ÁREA 4: PANEL DE INFORMACIÓN (Uso de weight)[cite: 1]
                    // ==========================================
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFF263238)) // Contenedor oscuro
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Lado izquierdo: Peso 0.2f con icono informativo[cite: 1]
                        Box(
                            modifier = Modifier.weight(0.2f),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Info,
                                contentDescription = "Info",
                                tint = Color.White,
                                modifier = Modifier.size(36.dp)
                            )
                        }

                        // Lado derecho: Peso 0.8f con Título y Descripción dinámica[cite: 1]
                        Column(
                            modifier = Modifier
                                .weight(0.8f)
                                .padding(start = 8.dp)
                        ) {
                            Text(
                                text = itemPrincipalSeleccionado.titulo,
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = itemPrincipalSeleccionado.descripcion,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.LightGray,
                                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                            )
                        }
                    }

                    // ==========================================
                    // ÁREA 5: FORMULARIO DE VISITA (OutlinedTextField)[cite: 1, 3]
                    // ==========================================
                    OutlinedTextField(
                        value = nombreVisitante,
                        onValueChange = { nombreVisitante = it },
                        label = { Text("Nombre del visitante") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = comentarioExperiencia,
                        onValueChange = { comentarioExperiencia = it },
                        label = { Text("Comentario / Experiencia") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        maxLines = 4
                    )

                    // ==========================================
                    // ÁREA 6: PANEL DE ACCIÓN (Variedad de Botones)[cite: 1]
                    // ==========================================
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Botón Limpiar (OutlinedButton)[cite: 1]
                        OutlinedButton(onClick = {
                            nombreVisitante = ""
                            comentarioExperiencia = ""
                            mensajeError = ""
                            ticketPublicado = null
                            Log.d(TAG, "Formulario limpiado por el usuario.")
                        }) {
                            Text("Limpiar")
                        }

                        // Botón Publicar (FilledTonalButton)[cite: 1]
                        FilledTonalButton(onClick = {
                            if (nombreVisitante.isBlank() || comentarioExperiencia.isBlank()) {
                                mensajeError = "Error: Todos los campos deben estar rellenados."
                                ticketPublicado = null
                                Log.d(TAG, "Intento de publicación fallido: Campos vacíos.")
                            } else {
                                mensajeError = ""
                                ticketPublicado = Triple(nombreVisitante, temaSeleccionado, comentarioExperiencia)
                                Log.d(TAG, "Registro publicado correctamente para el visitante: $nombreVisitante")
                            }
                        }) {
                            Text("Publicar Registro")
                        }
                    }

                    // ==========================================
                    // ÁREA 7: RESULTADOS Y MÉTRICAS (onTextLayout)[cite: 1, 2]
                    // ==========================================
                    if (mensajeError.isNotEmpty()) {
                        Text(
                            text = mensajeError,
                            color = Color.Red,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        )
                    }

                    ticketPublicado?.let { (visitante, parque, comentario) ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFE8F5E9), RoundedCornerShape(8.dp))
                                .padding(12.dp)
                        ) {
                            Column(modifier = Modifier.align(Alignment.CenterEnd)) {
                                Text(
                                    text = "¡Ticket de Visita Confirmado!",
                                    style = MaterialTheme.typography.titleSmall,
                                    color = Color(0xFF2E7D32)
                                )
                                Spacer(modifier = Modifier.height(4.dp))

                                // Texto con onTextLayout obligatorio para medir métricas en Logcat[cite: 1, 2]
                                Text(
                                    text = "Visitante: $visitante\nParque: $parque\nComentario: $comentario",
                                    color = Color(0xFF1B5E20),
                                    onTextLayout = { textLayoutResult ->
                                        Log.d(TAG, "--- MÉTRICAS DEL TEXTO PUBLICADO ---")
                                        Log.d(TAG, "Líneas totales (lineCount): ${textLayoutResult.lineCount}")
                                        Log.d(TAG, "¿Tiene desbordamiento visual? (hasVisualOverflow): ${textLayoutResult.hasVisualOverflow}")
                                    }
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    }
}

// Data Class auxiliar recomendada en los apuntes para agrupar recursos de imágenes[cite: 1, 3]
data class ItemParque(
    val imageRes: Int,
    val titulo: String,
    val descripcion: String
)

// Objeto de ayuda para colores temáticos adaptados a las prácticas[cite: 1]
object MaterialColorHelper {
    fun getColorThemePrimary(tema: String): Color {
        return when (tema) {
            "Disney" -> Color(0xFF1976D2)      // Azul
            "P.Aventura" -> Color(0xFFF57F17)  // Naranja / Amarillo
            else -> Color(0xFFC62828)          // Rojo
        }
    }

    fun getColorThemeAccent(tema: String): Color {
        return when (tema) {
            "Disney" -> Color(0xFF0D47A1)
            "P.Aventura" -> Color(0xFFEF6C00)
            else -> Color(0xFFB71C1C)
        }
    }
}