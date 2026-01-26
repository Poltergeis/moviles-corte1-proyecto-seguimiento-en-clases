package com.example.myapplicationexample1.AhorcadoGame.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.math.ceil

const val abc = "abcdefghijklmnñopqrstuvwxyz"

@Composable
fun AhorcadoKeyboard(
    tryFunc: (value: String) -> Unit,
    states: Map<String, Boolean>,
    charsPerRow: Int = 7
){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        FlowRow(
            modifier = Modifier.fillMaxHeight().fillMaxWidth(0.95f),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            maxItemsInEachRow = charsPerRow
        ) {
            for(char in abc){
                val charStr = char.toString()
                key(char) {
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = { tryFunc(charStr) },
                        enabled = states[charStr] ?: false,
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(charStr)
                    }
                }
            }
        }
    }
}