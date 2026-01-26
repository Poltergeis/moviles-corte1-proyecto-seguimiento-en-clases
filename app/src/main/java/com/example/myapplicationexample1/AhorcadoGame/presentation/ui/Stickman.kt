package com.example.myapplicationexample1.AhorcadoGame.presentation.ui

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun AhorcadoCanvas(
    modifier: Modifier,
    errores: Int,
    color: Color = Color.Black
) {
    Canvas(modifier = modifier) {
        val sW = size.width
        val sH = size.height
        val strokePx = 6f

        drawLine(color, Offset(sW * 0.1f, sH * 0.9f), Offset(sW * 0.5f, sH * 0.9f), strokePx)

        drawLine(color, Offset(sW * 0.2f, sH * 0.9f), Offset(sW * 0.2f, sH * 0.1f), strokePx)

        drawLine(color, Offset(sW * 0.2f, sH * 0.1f), Offset(sW * 0.6f, sH * 0.1f), strokePx)

        drawLine(color, Offset(sW * 0.6f, sH * 0.1f), Offset(sW * 0.6f, sH * 0.2f), strokePx)

        val centerX = sW * 0.6f
        val startY = sH * 0.2f

        val headRadius = sH * 0.08f // Cabeza más pequeña
        val bodyLen = sH * 0.25f
        val armLen = sH * 0.15f

        // Cabeza (Error 1)
        if (errores >= 1) {
            drawCircle(color, headRadius, Offset(centerX, startY + headRadius), style = Stroke(strokePx))
        }

        // Torso (Error 2)
        val torsoTop = startY + (headRadius * 2)
        val torsoBottom = torsoTop + bodyLen
        if (errores >= 2) {
            drawLine(color, Offset(centerX, torsoTop), Offset(centerX, torsoBottom), strokePx)
        }

        // Brazo Izquierdo (Error 3)
        if (errores >= 3) {
            drawLine(color, Offset(centerX, torsoTop + 20f), Offset(centerX - armLen, torsoTop + armLen), strokePx)
        }

        // Brazo Derecho (Error 4)
        if (errores >= 4) {
            drawLine(color, Offset(centerX, torsoTop + 20f), Offset(centerX + armLen, torsoTop + armLen), strokePx)
        }

        // Pierna Izquierda (Error 5)
        if (errores >= 5) {
            drawLine(color, Offset(centerX, torsoBottom), Offset(centerX - armLen, torsoBottom + armLen), strokePx)
        }

        // Pierna Derecha (Error 6)
        if (errores >= 6) {
            drawLine(color, Offset(centerX, torsoBottom), Offset(centerX + armLen, torsoBottom + armLen), strokePx)
        }
    }
}