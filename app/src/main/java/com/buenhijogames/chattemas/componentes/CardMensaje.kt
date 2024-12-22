package com.buenhijogames.chattemas.componentes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.buenhijogames.chattemas.model.ModeloDeMensajes

//https://material-foundation.github.io/material-theme-builder

@Composable
fun CardMensaje(mensaje: ModeloDeMensajes) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = if (mensaje.esMiMensaje) Alignment.CenterEnd else Alignment.CenterStart
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = if (mensaje.esMiMensaje) MaterialTheme.colorScheme.surfaceDim
                else MaterialTheme.colorScheme.tertiaryContainer
            ),
            modifier = Modifier.padding(16.dp).fillMaxWidth(fraction = 0.75f),
        ) {
            Text(mensaje.texto, modifier = Modifier.padding(16.dp))
        }
    }
}