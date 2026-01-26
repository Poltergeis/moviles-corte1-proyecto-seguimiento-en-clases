package com.example.myapplicationexample1.AhorcadoGame.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableInferredTarget
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.myapplicationexample1.AhorcadoGame.presentation.ui.AhorcadoCanvas
import com.example.myapplicationexample1.AhorcadoGame.presentation.ui.AhorcadoKeyboard
import com.example.myapplicationexample1.AhorcadoGame.presentation.viewmodel.AhorcadoViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AhorcadoScreen(viewmodel: AhorcadoViewModel = viewModel()){
    val titlevalue by viewmodel.title.collectAsStateWithLifecycle()
    val keyStatesMapValue by viewmodel.keyStates.collectAsStateWithLifecycle()
    val erroresCount by viewmodel.errores.collectAsStateWithLifecycle()
    val progress by viewmodel.progress.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().weight(0.2f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = titlevalue,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth().weight(1.5f),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AhorcadoCanvas(
                modifier = Modifier.fillMaxSize(), erroresCount,
                Color.Black
            )
        }
        Row(
            Modifier.fillMaxWidth().weight(0.6f)
        ) {
            Spacer(Modifier.weight(0.5f))
            FlowRow(
                modifier = Modifier.weight(9f).fillMaxHeight(),
                horizontalArrangement = Arrangement.Center,
                verticalArrangement = Arrangement.Center,
                maxItemsInEachRow = 8
            ) {
                progress.forEach { letra ->
                    Text(
                        text = if (letra == " ") " " else letra,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    )
                }
            }
            Spacer(Modifier.weight(0.5f))
        }
        Column(
            modifier = Modifier.fillMaxWidth().weight(1f),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AhorcadoKeyboard(
                viewmodel::tryChar,
                keyStatesMapValue
            )
        }
    }
}