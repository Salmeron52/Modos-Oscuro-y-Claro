package com.buenhijogames.chattemas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.buenhijogames.chattemas.ui.mi_tema.MiTema
import com.buenhijogames.chattemas.ui.pantallas.PantallaPrincipal
import com.buenhijogames.chattemas.ui.theme.ChatTemasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiTema {
                PantallaPrincipal()
            }
        }
    }
}

