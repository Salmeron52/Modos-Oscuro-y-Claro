package com.buenhijogames.chattemas.componentes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.buenhijogames.chattemas.model.ModeloDeMensajes

//https://material-foundation.github.io/material-theme-builder

@Composable
fun BoxMensajes(modifier: Modifier, listaDeMensajes: List<ModeloDeMensajes>) {
    Box(
        modifier = modifier.fillMaxWidth().verticalScroll(rememberScrollState())
    ) {
        Column {
            listaDeMensajes.forEach {
                CardMensaje(mensaje = it)
            }
        }

    }
}