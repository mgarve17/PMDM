package com.example.practica4_ut2.data

data class Artista(

    val id: Int,
    val nombre: String,
    val ciudad: String,
    val nacionalidad: String,
    val estilo: String,
    val anioInicio: String,
    val biografia: String,
    val imagenUrl: String


)

object RepositorioArtistas{
    val listaArtistas: List<Artista> = listOf(

        Artista(
            id = 0,
            nombre = "Loona",
            ciudad = "Seul",
            nacionalidad = "Coreana",
            estilo = "Kpop",
            anioInicio = "2018",
            biografia = "Las mejores que vuelvan las extraño con la fuerza de mil soles",
            imagenUrl = "https://commons.wikimedia.org/wiki/File:190517_Loona_for_TenAsia.png"
        ),

        Artista(

            id = 1,
            nombre = "Clairo",
            ciudad = "Atlanta, Estados Unidos",
            nacionalidad = "Americana",
            estilo = "Pop/Folk",
            anioInicio = "2018",
            biografia = "Es mi mejor amiga y lo sabe",
            imagenUrl = "https://commons.wikimedia.org/wiki/File:Clairo_@_Fonda_Theatre_09_08_2024_(54012644985).jpg"

        ),
        Artista(

            id = 2,
            nombre = "Inhaler",
            ciudad = "Dublin",
            nacionalidad = "Irlandesa",
            estilo = "Pop rock",
            anioInicio = "2021",
            biografia = "qué guapa está dublin in ecstasy",
            imagenUrl = "https://commons.wikimedia.org/wiki/File:NDLE2022Inhaler_04.jpg"
        ),

        Artista(

            id = 3,
            nombre = "Wallows",
            ciudad = "Los Ángeles",
            nacionalidad = "Americana",
            estilo = "Pop rock",
            anioInicio = "2017",
            biografia = "miau",
            imagenUrl = "https://commons.wikimedia.org/wiki/File:Wallows_new_profile_picture_for_Wikipedia_(anytime,always_wallows_2024).png"
        )
    )

    fun obtenerArtistaPorId(id: Int): Artista? {
        return listaArtistas.find { it.id == id }
    }

}
