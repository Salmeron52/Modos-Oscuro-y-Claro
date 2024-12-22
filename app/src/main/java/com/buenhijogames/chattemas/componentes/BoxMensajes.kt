package com.buenhijogames.chattemas.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.buenhijogames.chattemas.ui.mi_tema.backgroundDark

@Composable
fun BoxMensajes(modifier: Modifier) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Column {
            CardMensaje(esMiMensaje = true, mensaje = "Hola")

            CardMensaje(esMiMensaje = false, mensaje = "Adiós")
        }

    }
}