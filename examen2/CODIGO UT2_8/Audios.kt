package com.example.ut2_8.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.ut2_8.R
import com.example.ut2_8.model.AudioMusical
import com.example.ut2_8.model.AudioMusicalExt
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
val audiosMusicales = listOf(
    AudioMusical(
        titulo = "El Encuentro",
        artist = "Vetusta Morla",
        imagen = R.drawable.vetusta_morla_el_encuentro, // O R.drawable.vetusta_morla_el_encuentro
        audio = 1,
        fecha = LocalDate.of(2024, 11, 4),
        estrellas = 4.6
    ),
    AudioMusical(
        titulo = "Baile Existencialista",
        artist = "León Benavente",
        imagen = R.drawable.leon_benavente_baile_existencialista, // O R.drawable.leon_benavente_baile_existencialista
        audio = 2,
        fecha = LocalDate.of(2024, 11, 5),
        estrellas = 4.7
    ),
    AudioMusical(
        titulo = "Devenir Paisaje",
        artist = "Fin del Mundo",
        imagen = R.drawable.fin_del_mundo_devenir_paisaje, // O R.drawable.fin_del_mundo_devenir_paisaje
        audio = 3,
        fecha = LocalDate.of(2024, 11, 12),
        estrellas = 4.6
    ),
    AudioMusical(
        titulo = "Brujería!",
        artist = "Judeline",
        imagen = R.drawable.judeline_brujeria, // O R.drawable.judeline_brujeria
        audio = 4,
        fecha = LocalDate.of(2024, 11, 8),
        estrellas = 4.4
    ),
    AudioMusical(
        titulo = "Nos Volveremos a Ver",
        artist = "La La Love You",
        imagen = R.drawable.la_la_love_you_nos_volveremos_a_ver, // O R.drawable.la_la_love_you_nos_volveremos_a_ver
        audio = 5,
        fecha = LocalDate.of(2024, 11, 6),
        estrellas = 4.6
    ),
    AudioMusical(
        titulo = "Tenemos la respuesta",
        artist = "ELYELLA feat. Lori Meyers",
        imagen = R.drawable.elyella_tenemos_la_respuesta, // O R.drawable.elyella_tenemos_la_respuesta
        audio = 6,
        fecha = LocalDate.of(2024, 11, 10),
        estrellas = 4.5
    )
)

// Recuerda añadir arriba del archivo Audios.kt:
// import com.example.appmusica.model.AudioMusicalExt

val audiosMusicalesExt = listOf(
    AudioMusicalExt(
        titulo = "El Encuentro",
        artist = "Vetusta Morla",
        urlImagen = "https://picsum.photos/id/1015/600/400.jpg",
        urlAudio = "",
        fecha = LocalDate.of(2024, 11, 4),
        estrellas = 4.6
    ),
    AudioMusicalExt(
        titulo = "Baile Existencialista",
        artist = "León Benavente",
        urlImagen = "https://picsum.photos/id/1016/600/400.jpg",
        urlAudio = "",
        fecha = LocalDate.of(2024, 11, 5),
        estrellas = 4.7
    ),
    AudioMusicalExt(
        titulo = "Devenir Paisaje",
        artist = "Fin del Mundo",
        urlImagen = "https://picsum.photos/id/1018/600/400.jpg",
        urlAudio = "",
        fecha = LocalDate.of(2024, 11, 12),
        estrellas = 4.6
    ),
    AudioMusicalExt(
        titulo = "Brujería!",
        artist = "Judeline",
        urlImagen = "https://picsum.photos/id/1019/600/400.jpg",
        urlAudio = "",
        fecha = LocalDate.of(2024, 11, 8),
        estrellas = 4.4
    ),
    AudioMusicalExt(
        titulo = "Nos Volveremos a Ver",
        artist = "La La Love You",
        urlImagen = "https://picsum.photos/id/1020/600/400.jpg",
        urlAudio = "",
        fecha = LocalDate.of(2024, 11, 6),
        estrellas = 4.6
    ),
    AudioMusicalExt(
        titulo = "Tenemos la respuesta",
        artist = "ELYELLA feat. Lori Meyers",
        urlImagen = "https://picsum.photos/id/1021/600/400.jpg",
        urlAudio = "",
        fecha = LocalDate.of(2024, 11, 10),
        estrellas = 4.5
    )
)