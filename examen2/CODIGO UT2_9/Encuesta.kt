package com.example.ut2_8.model

// Ojo: Hay que poner 'val' delante de pregunta y respuestas para poder leerlas después (en el paso 1.6)
sealed class Encuesta(val pregunta: String, val respuestas: List<String>) {
    object EncuestaHoy : Encuesta(
        pregunta = "¿cual es el módulo que menos te gusta?",
        respuestas = listOf("AD", "DI", "PSP", "PMDM")
    )
    object EncuestaAyer : Encuesta(
        pregunta = "¿que grado de satisfacción tienes con el ciclo?",
        respuestas = listOf(
            "Totalmente satisfecho",
            "Bastante satisfecho",
            "Poco satisfecho",
            "Nada satisfecho"
        )
    )
}