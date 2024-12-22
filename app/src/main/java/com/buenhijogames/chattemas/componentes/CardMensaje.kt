package com.buenhijogames.chattemas.componentes

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CardMensaje(esMiMensaje: Boolean, mensaje: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (esMiMensaje) MaterialTheme.colorScheme.surfaceDim
            else MaterialTheme.colorScheme.tertiaryContainer
        ),
        modifier = Modifier.padding(16.dp),
    ) {
        Text(mensaje, modifier = Modifier.padding(16.dp))
    }
}