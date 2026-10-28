package com.example.examenut1_maya.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.example.examenut1_maya.R

data class TipoCafe(

    @DrawableRes val idRecurso: Int,
    val nombre: String,
    val descripcion: String,
    val intensidad: Int



)

enum class CafeTema(

    val nombre: String,
    val backgroundColor: Color,
    val colorAcento: Color,
    val imagenes: List<TipoCafe>
) {

    EXPRESSOS(

        nombre = "Expressos",
        backgroundColor = Color(0xFF1E1E1E),
        colorAcento = Color(0xFF8D6E63),
        imagenes = listOf(

            TipoCafe(R.drawable.espresso, nombre = "Expresso" ,
                "Café corto, intenso y con crema.", intensidad = 4),
            TipoCafe(idRecurso = R.drawable.ristretto, nombre = "Ristretto",
                "Más corto y concentrado que el espresso. ", intensidad = 5),
            TipoCafe(idRecurso = R.drawable.lungo, nombre = "Lungo",
                "Extracción más larga, sabor más suave. ", intensidad = 3),
            TipoCafe(idRecurso = R.drawable.americano, nombre = "Americano",
                "Espresso alargado con agua. ", intensidad = 2)
        )

    ),

    BEBIDASCONLECHE(

        nombre = "Bebidas con leche",
        backgroundColor = Color(0xFF1E1E1E),
        colorAcento = Color(0xFFD7CCC8),
        imagenes = listOf(

            TipoCafe(R.drawable.latte, nombre = "Café latte" ,
                "Mucha leche, sabor suave.", intensidad = 1),
            TipoCafe(R.drawable.capuchino, nombre = "Capuchno" ,
                "Espresso, leche y espuma en partes equilibradas. ", intensidad = 3),
            TipoCafe(R.drawable.flat_white, nombre = "Flat white" ,
                "Similar al latte, pero más intenso. ", intensidad = 4),
            TipoCafe(R.drawable.cortado, nombre = "Cortado" ,
                " Espresso “manchado” con poca leche. ", intensidad = 4)
        )

    ),

    CAFESAUTOR(

        nombre = "Cafes de autor",
        backgroundColor = Color(0xFF1E1E1E),
        colorAcento = Color(0xFFFFB300),
        imagenes = listOf(

            TipoCafe(R.drawable.cortado, nombre = "Moca" ,
                " Espresso “manchado” con poca leche. ", intensidad = 3),
            TipoCafe(R.drawable.bombon, nombre = "Bombón" ,
                " Espresso “manchado” con poca leche. ", intensidad = 4),
            TipoCafe(R.drawable.vienes, nombre = "Vienés" ,
                " Espresso “manchado” con poca leche. ", intensidad = 3),
            TipoCafe(R.drawable.carajillo, nombre = "Carajillo" ,
                " Espresso “manchado” con poca leche. ", intensidad = 5),
            TipoCafe(R.drawable.irlandes, nombre = "Café Irlandés" ,
                " Espresso “manchado” con poca leche. ", intensidad = 5)
        )
    )

}


