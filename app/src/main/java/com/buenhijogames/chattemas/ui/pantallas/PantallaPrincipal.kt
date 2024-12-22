package com.buenhijogames.chattemas.ui.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.buenhijogames.chattemas.componentes.BoxMensajes
import com.buenhijogames.chattemas.componentes.ChatTextField
import com.buenhijogames.chattemas.model.ModeloDeMensajes
import com.buenhijogames.chattemas.ui.mi_tema.temas.original.color1
import com.buenhijogames.chattemas.utilidades.respuestaAleatoria
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//https://material-foundation.github.io/material-theme-builder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Elige un tema", modifier = Modifier.padding(16.dp), fontSize = 20.sp)
                HorizontalDivider(color = Color.Gray)
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable { scope.launch { drawerState.close() } }) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(color1)
                        )
                        Text(
                            "Tema original",
                            fontSize = 18.sp,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
                HorizontalDivider(color = Color.LightGray)
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable { scope.launch { drawerState.close() } }) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(color1)
                        )
                        Text(
                            "Tema Mar",
                            fontSize = 18.sp,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
                HorizontalDivider(color = Color.LightGray)
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable { scope.launch { drawerState.close() } }) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clip(CircleShape)
                                .background(color1)
                        )
                        Text(
                            "Tema Naturaleza",
                            fontSize = 18.sp,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
                HorizontalDivider(color = Color.LightGray)
            }
        }
    ) {
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
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }, colors = IconButtonDefaults.iconButtonColors(
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
}