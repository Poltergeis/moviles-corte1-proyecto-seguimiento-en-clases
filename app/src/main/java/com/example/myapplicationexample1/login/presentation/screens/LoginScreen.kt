package com.example.myapplicationexample1.login.presentation.screens

import android.graphics.drawable.shapes.RoundRectShape
import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplicationexample1.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplicationexample1.login.domain.usecase.LoginUseCase
import com.example.myapplicationexample1.login.presentation.viewmodel.LoginViewModel
import com.example.myapplicationexample1.login.presentation.viewmodelfactory.LoginViewModelFactory

@Composable

fun LoginScreen(viewmodel: LoginViewModel = viewModel(
    factory = LoginViewModelFactory(loginUseCase = LoginUseCase())
)){
    val usernameState by viewmodel.username.collectAsStateWithLifecycle()
    val passwordState by viewmodel.password.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Surface(
            color = Color(125, 42, 32), //cafe
            shape = RoundedCornerShape(12.dp)
        ){
            Column(
                modifier = Modifier.height(50.dp).width(200.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Bienvenido", color = Color.White, fontSize = 22.sp)
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(200.dp),
                painter = painterResource(R.drawable.my_example_logo),
                contentDescription = "logo de mi empresa"
            )
            Spacer(modifier = Modifier.height(50.dp))
            TextField(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 10.dp),
                placeholder = { Text("Username") },
                value = usernameState,
                onValueChange = { it: String -> viewmodel.setUsername(it) },
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 10.dp),
                placeholder = {Text("password")},
                value = passwordState,
                onValueChange = { it:String -> viewmodel.setPassword(it) }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {}
            ) {
                Text("iniciar sesion")
            }
        }
        Column(
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            Text("@Mi empresa")
        }
    }
}