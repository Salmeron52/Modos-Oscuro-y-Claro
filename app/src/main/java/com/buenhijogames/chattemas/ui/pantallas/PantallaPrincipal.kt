package com.buenhijogames.chattemas.ui.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import com.buenhijogames.chattemas.componentes.BoxMensajes
import com.buenhijogames.chattemas.componentes.ChatTextField
import com.buenhijogames.chattemas.model.ModeloDeMensajes
import com.buenhijogames.chattemas.utilidades.respuestaAleatoria
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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

            var mensaje by rememberSaveable { mutableStateOf("") }
            val focusManager = LocalFocusManager.current
            var listaDeMensajes by rememberSaveable {
                mutableStateOf(listOf<ModeloDeMensajes>())
            }
            val scrollState = rememberScrollState()
            val scope = rememberCoroutineScope()

            //Mensajes
            BoxMensajes(
                modifier = Modifier.weight(1f),
                listaDeMensajes = listaDeMensajes,
                scrollState = scrollState
            )

            //TextField
            ChatTextField(
                mensaje = mensaje,
                onMensajeChange = { mensaje = it },
                onMensajeSent = {
                    val nuevoMensaje = ModeloDeMensajes(texto = mensaje, esMiMensaje = true)
                    mensaje = ""
                    listaDeMensajes = listaDeMensajes + nuevoMensaje
                    val respuesta = respuestaAleatoria()
                    scope.launch {
                        delay(150) //para que compose recomponga antes de hacer scroll
                        scrollState.animateScrollTo(scrollState.maxValue)
                        delay(300)
                        listaDeMensajes = listaDeMensajes + respuesta
                        delay(150)
                        scrollState.animateScrollTo(scrollState.maxValue)
                    }
                },
                quitarTeclado = { focusManager.clearFocus() }
            )
        }
    }
}