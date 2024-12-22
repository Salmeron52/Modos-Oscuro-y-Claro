package com.buenhijogames.chattemas.utilidades

import com.buenhijogames.chattemas.model.ModeloDeMensajes

val listaDeRespuestas = listOf<String>(
    "Hola",
    "¿Cómo estás?",
    "¿Qué tal?",
    "¿Qué haces?",
    "¿Qué cuentas?",
    "¿Qué hay de nuevo?",
    "¿Qué pasa?",
    "Muy interesante",
    "¡Qué bien!",
    "¡Qué guay!",
    "¡Qué chulo!",
    "¡Qué bonito!",
    "¿Y qué más?",
    "¿Y qué más cuentas?",
    "¿Y qué más hay?",
    "¿Y qué más pasa?",
    "¿Y qué más haces?"
)

fun respuestaAleatoria(): ModeloDeMensajes {
    val respuestaAleatoria =  listaDeRespuestas.random()

    val respuesta = ModeloDeMensajes(
        texto = respuestaAleatoria,
        esMiMensaje = false
    )
    return respuesta
}