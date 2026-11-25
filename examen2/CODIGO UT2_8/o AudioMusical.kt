package com.example.ut2_8.model

import java.time.LocalDate

data class AudioMusical(
    val titulo: String,
    val artist: String,
    val imagen: Int,
    val audio: Int,
    val fecha: LocalDate,
    val estrellas: Double
)