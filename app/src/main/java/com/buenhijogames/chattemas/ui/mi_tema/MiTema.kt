package com.buenhijogames.chattemas.ui.mi_tema

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.buenhijogames.chattemas.ui.mi_tema.temas.naturaleza.esquemaModoClaroNaturaleza
import com.buenhijogames.chattemas.ui.mi_tema.temas.naturaleza.esquemaModoOscuroNaturaleza
import com.buenhijogames.chattemas.ui.mi_tema.temas.original.esquemaModoClaroOriginal
import com.buenhijogames.chattemas.ui.mi_tema.temas.original.esquemaModoOscuroOriginal


@Composable
fun MiTema(
    dynamicColors: Boolean = false,
    modoOscuro: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    //TODO: Definir colores
    var colores : ColorScheme

    if (dynamicColors && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val context = LocalContext.current
        colores = if (modoOscuro) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    } else {
        colores = if (modoOscuro) esquemaModoOscuroNaturaleza else esquemaModoClaroNaturaleza
    }
    //TODO: Definir tipografía
    MaterialTheme(
        colorScheme = colores,
        content = content
    )
}