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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.example.urbis.ui.viewmodel.AuthViewModel

@Composable
fun LoginScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // --- 1. UBICACIÓN DEL LAUNCHED EFFECT ---
    // Se coloca aquí para que esté "escuchando" cambios desde que se carga la pantalla
    LaunchedEffect(authViewModel.userRole) {
        authViewModel.userRole?.let { role ->
            if (role == "admin") {
                navController.navigate("admin_list") {
                    popUpTo(Screens.Login.route) { inclusive = true }
                }
            } else {
                navController.navigate("mapa") {
                    popUpTo(Screens.Login.route) { inclusive = true }
                }
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Urbis Cádiz", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            enabled = !authViewModel.isLoading
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            enabled = !authViewModel.isLoading
        )

        val errorText = authViewModel.errorMessage
        if (errorText != null) {
            Text(
                text = errorText.toString(),
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- 2. MODIFICACIÓN DEL BOTÓN ---
        Button(
            onClick = {
                authViewModel.login(email, password) {
                    // Al tener éxito, buscamos el UID y pedimos el rol
                    val uid = com.google.firebase.auth.FirebaseAuth.getInstance().currentUser?.uid
                    if (uid != null) {
                        authViewModel.checkUserRole(uid)
                    }
                }
            },
            modifier = Modifier.fillMaxWidth().height(56.dp),
            enabled = !authViewModel.isLoading
        ) {
            if (authViewModel.isLoading) CircularProgressIndicator() else Text("Entrar")
        }

        TextButton(onClick = { navController.navigate(Screens.Register.route) }) {
            Text("¿No tienes cuenta? Regístrate")
        }
    }
}