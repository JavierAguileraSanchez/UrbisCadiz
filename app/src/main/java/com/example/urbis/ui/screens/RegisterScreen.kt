package com.example.urbis.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.urbis.ui.navigation.Screens
import com.example.urbis.ui.viewmodel.AuthViewModel

@Composable
fun RegisterScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    // Estados locales para los campos de texto
    var nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Crear Cuenta",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(32.dp))

        // CAMPO NOMBRE (Crítico para tu Firestore)
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre Completo") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            enabled = !authViewModel.isLoading
        )

        Spacer(modifier = Modifier.height(16.dp))

        // CAMPO EMAIL
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo Electrónico") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            enabled = !authViewModel.isLoading
        )

        Spacer(modifier = Modifier.height(16.dp))

        // CAMPO PASSWORD
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            enabled = !authViewModel.isLoading
        )

        // MOSTRAR ERROR SI EXISTE
        // 1. Extraemos el valor del ViewModel a una variable local de tipo String opcional
        val msg: String? = authViewModel.errorMessage

        // 2. Usamos un IF tradicional
        if (msg != null) {
            Text(
                text = msg, // Al ser 'msg' una val local, el Smart Cast a String es obligatorio
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 8.dp),
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // BOTÓN DE REGISTRO
        Button(
            onClick = {
                authViewModel.signUp(email, password, nombre) {
                    // Si el registro tiene éxito, vamos al Mapa
                    navController.navigate("mapa") {
                        // Limpiamos el historial para que no pueda volver atrás al registro
                        popUpTo(Screens.Login.route) { inclusive = true }
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            enabled = !authViewModel.isLoading // Se deshabilita mientras carga
        ) {
            if (authViewModel.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = MaterialTheme.colorScheme.onPrimary,
                    strokeWidth = 2.dp
                )
            } else {
                Text("Registrarse")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // BOTÓN VOLVER
        TextButton(
            onClick = { navController.popBackStack() },
            enabled = !authViewModel.isLoading
        ) {
            Text("¿Ya tienes cuenta? Inicia sesión")
        }
    }
}