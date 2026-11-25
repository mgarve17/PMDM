package com.example.sesion3_03_base.model

data class Animal(

    val binomialName: String ="",
    val commonName: String ="",
    val imageSrc: String ="",
    val lastRecord: String = "",
    val location: String ="",
    val shortDesc: String = ""
)

data class AnimalResponse(
    val status: String,
    val data: List<Animal>
)
