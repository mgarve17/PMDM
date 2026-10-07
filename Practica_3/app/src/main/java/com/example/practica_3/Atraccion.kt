package com.example.practica_3

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Atraccion(

    @DrawableRes val imageRes: Int,
    val titulo: String,
    val descripcion: String
)

//Enum de los temas para cada parque
enum class ParqueTema(
    val nombre: String,
    val backgroundColor: Color,
    val primaryColor: Color,
    val imagenes: List<Atraccion>
) {

    DISNEY(
        nombre = "Disney",
        backgroundColor = Color(0xFFE1F5FE), // Azul claro
        primaryColor = Color(0xFF0288D1),
        imagenes = listOf(
            Atraccion(R.drawable.i1, "Entrada Principal", "Bienvenidos al mundo de la diversión"),
            Atraccion(R.drawable.i2, "Castillo Disney", "Un lugar lleno de magia y fantasía"),
            Atraccion(R.drawable.i3, "Mickey & Amigos", "Conoce a tus personajes favoritos")
        )
    ),

    PORT_AVENTURA(
        nombre = "P.Aventura",
        primaryColor = Color(0xFFE53935),
        backgroundColor = Color(0xFFFBC02D),
        imagenes = listOf(
            Atraccion(R.drawable.i4, "Dragon Khan", "Siente la furia del dragon"),
            Atraccion(imageRes = R.drawable.i5, titulo = "Shambhala", "La montaña rusa más alta del parque"),
            Atraccion(imageRes = R.drawable.i6, titulo = "Furius Baco","Aceleración vertiginosa")
        )
    ),

    WARNER(
        nombre = "Warner",
        backgroundColor = Color(0xFFFFEBEE),
        primaryColor = Color(0xFFE53935),
        imagenes = listOf(
            Atraccion(R.drawable.i7,"Superman","Vuelo de acero sin suelo bajo tus pies"),
            Atraccion(R.drawable.i8, "Batman Gotman", "Aventura en las sombras"),
            Atraccion(R.drawable.i9, "Coaster Express", "La montaña rusa de madera")
        )
    ),
}

val imagenesGenericas = listOf(
    Atraccion(R.drawable.i10,"Atracción Infantil", "Diversion segura"),
    Atraccion(R.drawable.i11,"Zona Acuática", "Para refrescarse")
)
