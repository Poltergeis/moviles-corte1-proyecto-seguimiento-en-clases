package com.example.myapplicationexample1.AhorcadoGame.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

const val abc = "abcdefghijklmnñopqrstuvwxyz"
class AhorcadoViewModel : ViewModel() {
    private val palabra = "medicina moderna"
    private val maxErrores = 6

    private val _title = MutableStateFlow("En progreso")
    val title = _title.asStateFlow()

    private val _progress = MutableStateFlow(
        palabra.map { if (it == ' ') " " else "_" }
    )
    val progress = _progress.asStateFlow()

    private val _keyStates = MutableStateFlow(
        abc.map { it.toString() }.associateWith { true }
    )
    val keyStates = _keyStates.asStateFlow()

    // Nuevo estado para el dibujo del stickman
    private val _errores = MutableStateFlow(0)
    val errores = _errores.asStateFlow()

    fun tryChar(char: String) {
        // Si el juego ya terminó, no hacemos nada
        if (_title.value != "En progreso") return

        // 1. Deshabilitar la tecla pulsada
        _keyStates.value = _keyStates.value.toMutableMap().apply {
            this[char] = false
        }

        // 2. Verificar si la letra está en la palabra
        if (palabra.contains(char, ignoreCase = true)) {
            actualizarProgreso(char)
        } else {
            _errores.value += 1
        }

        // 3. Comprobar condiciones de victoria o derrota
        checkGameStatus()
    }

    private fun actualizarProgreso(char: String) {
        val nuevoProgreso = _progress.value.toMutableList()
        palabra.forEachIndexed { index, letra ->
            if (letra.toString().equals(char, ignoreCase = true)) {
                nuevoProgreso[index] = letra.toString() // Mantenemos el formato original
            }
        }
        _progress.value = nuevoProgreso
    }

    private fun checkGameStatus() {
        when {
            // Victoria: Ya no hay guiones bajos en el progreso
            !_progress.value.contains("_") -> {
                _title.value = "¡Victoria!"
                finalizarTeclado()
            }
            // Derrota: Se alcanzó el máximo de errores
            _errores.value >= maxErrores -> {
                _title.value = "Suerte la próxima"
                // Opcional: Mostrar la palabra completa al perder
                _progress.value = palabra.map { it.toString() }
                finalizarTeclado()
            }
        }
    }

    private fun finalizarTeclado() {
        // Ponemos todas las teclas en false para que no se pueda seguir jugando
        _keyStates.value = _keyStates.value.mapValues { false }
    }
}