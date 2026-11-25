package com.example.ut2_8.model

import java.time.LocalDate

data class AudioMusicalExt(
    val titulo: String,
    val artist: String,
    val urlImagen: String,
    val urlAudio: String,
    val fecha: LocalDate,
    val estrellas: Double
)