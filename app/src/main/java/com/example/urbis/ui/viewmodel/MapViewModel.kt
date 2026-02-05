package com.example.urbis.ui.viewmodel

import android.net.Uri
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.urbis.data.model.Incidencia
import com.example.urbis.data.repository.IncidenciaRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MapViewModel(private val repository: IncidenciaRepository) : ViewModel() {
    var listaIncidencias by mutableStateOf<List<Incidencia>>(emptyList())
    var esAdmin by mutableStateOf(false)
    var isUploading by mutableStateOf(false)
    var imagenSeleccionadaUri by mutableStateOf<Uri?>(null)

    fun cargarDatos() {
        viewModelScope.launch {
            val uid = FirebaseAuth.getInstance().currentUser?.uid ?: return@launch
            val role = repository.getUserRole(uid)
            esAdmin = role.equals("admin", ignoreCase = true) || role.equals("GESTOR", ignoreCase = true)

            if (esAdmin) {
                repository.getAllIncidencias().collectLatest { listaIncidencias = it }
            } else {
                repository.getIncidenciasAprobadas().collectLatest { listaIncidencias = it }
            }
        }
    }

    fun crearIncidencia(titulo: String, desc: String, lat: Double, lng: Double) {
        viewModelScope.launch {
            isUploading = true
            val url = imagenSeleccionadaUri?.let { repository.subirImagen(it) }
            val nueva = Incidencia(titulo=titulo, descripcion=desc, latitud=lat, longitud=lng, imagenUrl=url)
            repository.guardarIncidencia(nueva)
            imagenSeleccionadaUri = null
            isUploading = false
        }
    }

    fun cambiarEstado(incidencia: Incidencia, nuevoEstado: String) {
        viewModelScope.launch { repository.actualizarIncidencia(incidencia.copy(estado = nuevoEstado)) }
    }
}