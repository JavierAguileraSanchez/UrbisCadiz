package com.example.urbis.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.urbis.data.repository.AuthRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import com.google.firebase.firestore.FirebaseFirestore

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    // Estado para controlar si la app está operando (cargando)
    private val db = FirebaseFirestore.getInstance()
    var isLoading by mutableStateOf(false)
        private set

    // Estado para capturar mensajes de error y mostrarlos en la UI
    var errorMessage by mutableStateOf<String?>(null)
        private set

      //Función para registrar un nuevo usuario.Incluye el nombre que pide tu AuthRepository.

    var userRole by mutableStateOf<String?>(null)
        private set // Es mejor que solo el ViewModel pueda cambiarlo

    fun signUp(email: String, pass: String, nombre: String, onSuccess: () -> Unit) {
        if (email.isBlank() || pass.isBlank() || nombre.isBlank()) {
            errorMessage = "Todos los campos son obligatorios"
            return
        }

        viewModelScope.launch {
            isLoading = true
            errorMessage = null

            // Llamamos a la función register de tu AuthRepository
            val result = repository.register(email, pass, nombre, "user")

            result.onSuccess {
                isLoading = false
                onSuccess()
            }.onFailure { exception ->
                isLoading = false
                errorMessage = exception.message ?: "Ocurrió un error inesperado"
            }
        }
    }

    //Función para iniciar sesión

    fun login(email: String, pass: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null

            val result = repository.login(email, pass)

            result.onSuccess {
                isLoading = false
                onSuccess()
            }.onFailure { exception ->
                isLoading = false
                errorMessage = "Error al iniciar sesión: ${exception.message}"
            }
        }
    }

    //Función para cerrar sesión

    fun logout() {
        repository.logout()
    }


    fun checkUserRole(uid: String) {
        viewModelScope.launch {
            try {
                val doc = db.collection("usuarios").document(uid).get().await() // Cambiado a "usuarios"
                if (doc.exists()) {
                    userRole = doc.getString("role") ?: "user" // Cambiado a "role"
                }
            } catch (e: Exception) {
                userRole = "user"
            }
        }
    }
}