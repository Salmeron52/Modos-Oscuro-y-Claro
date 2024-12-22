package com.buenhijogames.chattemas.ui.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import com.buenhijogames.chattemas.componentes.BoxMensajes
import com.buenhijogames.chattemas.componentes.ChatTextField
import com.buenhijogames.chattemas.model.ModeloDeMensajes

//https://material-foundation.github.io/material-theme-builder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                title = { Text("Temas") },
                navigationIcon = {
                    IconButton(
                        onClick = {}, colors = IconButtonDefaults.iconButtonColors(
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menú"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.onSecondary),
        ) {
           /* val mensaje1 = ModeloDeMensajes(
                esMiMensaje = true,
                texto = "Hola, qué tal? En un lugar de la Mancha, de cuyo nombre no " +
                        "quiero acordarme, no ha mucho tiempo que vivía un hidalgo de los de " +
                        "lanza en astillero, adarga antigua, rocín flaco y galgo corredor."
            )
            val mensaje2 = ModeloDeMensajes(
                esMiMensaje = false,
                texto = "Hola, qué tal? Caminante, son tus huellas el caminno y nada más; " +
                        "caminante, no hay camino, se hace camino al andar. Al andar se hace " +
                        "el camino, y al volver la vista atrás se ve la senda que nunca se ha " +
                        "de volver a pisar. Caminante no hay camino sino estelas en la mar."
            )*/
            var mensaje by rememberSaveable { mutableStateOf("") }
            val focusManager = LocalFocusManager.current
            var listaDeMensajes by rememberSaveable {
                mutableStateOf(listOf<ModeloDeMensajes>())
            }
            //Mensajes
            BoxMensajes(modifier = Modifier.weight(1f), listaDeMensajes = listaDeMensajes)
            //TextField
            ChatTextField(
                mensaje = mensaje,
                onMensajeChange = { mensaje = it },
                onMensajeSent = { mensaje = "" },
                quitarTeclado = { focusManager.clearFocus() }
            )
        }
    }
}