package com.example.urbis.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.urbis.data.model.Incidencia
import com.example.urbis.ui.viewmodel.AuthViewModel
import com.example.urbis.ui.viewmodel.MapViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun MapScreen(
    navController: NavHostController,
    mapViewModel: MapViewModel,
    authViewModel: AuthViewModel,
    latParam: Double,
    lngParam: Double
) {
    var selectedIncidencia by remember { mutableStateOf<Incidencia?>(null) }
    var showDetailDialog by remember { mutableStateOf(false) }
    // 1. Inicialización: Carga datos y detecta el Rol
    LaunchedEffect(Unit) {
        mapViewModel.cargarDatos()
    }

    // 2. Estado de la Cámara (Se centra si viene del AdminList)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(latParam, lngParam), if (latParam != 36.5271) 15f else 10f)
    }

    // Estados para el diálogo de nueva incidencia
    var showDialog by remember { mutableStateOf(false) }
    var tempLatLng by remember { mutableStateOf<LatLng?>(null) }
    var titulo by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var showCreateDialog by remember { mutableStateOf(false) }

    // Launcher para la Galería
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        mapViewModel.imagenSeleccionadaUri = uri
    }

    Scaffold(
        floatingActionButton = {
            Column {
                // Solo el Admin ve el botón para ir a la lista de gestión
                if (mapViewModel.esAdmin) {
                    SmallFloatingActionButton(
                        onClick = { navController.navigate("admin_list") },
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        Icon(Icons.Default.List, contentDescription = "Ver Lista")
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(Modifier
            .fillMaxSize()
            .padding(innerPadding) // <--- AQUÍ SE CORRIGE EL ERROR
        ) {
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
                    onMapLongClick = { latLng ->
                    tempLatLng = latLng
                    showCreateDialog = true
                }
            ) {
                mapViewModel.listaIncidencias.forEach { incidencia ->
                    Marker(
                        state = MarkerState(position = LatLng(incidencia.latitud, incidencia.longitud)),
                        title = incidencia.titulo,
                        onClick = {
                            selectedIncidencia = incidencia
                            showDetailDialog = true
                            true
                        }
                    )
                }
            }

            // Mantenemos el indicador de carga si existe
            if (mapViewModel.isUploading) {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
        }

        // --- EL DIÁLOGO PUEDE IR AQUÍ O FUERA DEL BOX ---
        if (showDetailDialog && selectedIncidencia != null) {
            AlertDialog(
                onDismissRequest = { showDetailDialog = false },
                title = { Text(selectedIncidencia?.titulo ?: "Detalle") },
                text = {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        if (!selectedIncidencia?.imagenUrl.isNullOrBlank()) {
                            AsyncImage(
                                model = selectedIncidencia?.imagenUrl,
                                contentDescription = "Imagen",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                                    .clip(RoundedCornerShape(8.dp)),
                                contentScale = ContentScale.Crop
                            )
                            Spacer(Modifier.height(12.dp))
                        }
                        Text(selectedIncidencia?.descripcion ?: "", style = MaterialTheme.typography.bodyMedium)
                        Spacer(Modifier.height(8.dp))
                        Text("Estado: ${selectedIncidencia?.estado?.uppercase()}", color = MaterialTheme.colorScheme.primary)
                    }
                },
                confirmButton = {
                    TextButton(onClick = { showDetailDialog = false }) { Text("Cerrar") }
                }
            )
        }
    }
    if (showCreateDialog) {
        AlertDialog(
            onDismissRequest = { showCreateDialog = false },
            title = { Text("Nueva Incidencia") },
            text = {
                Column {
                    TextField(value = titulo, onValueChange = { titulo = it }, label = { Text("Título") })
                    Spacer(Modifier.height(8.dp))
                    TextField(value = descripcion, onValueChange = { descripcion = it }, label = { Text("Descripción") })
                    Spacer(Modifier.height(16.dp))

                    Button(onClick = { galleryLauncher.launch("image/*") }) {
                        Text(if (mapViewModel.imagenSeleccionadaUri != null) "Foto lista" else "Añadir Foto")
                    }
                }
            },
            confirmButton = {
                Button(onClick = {
                    tempLatLng?.let {
                        mapViewModel.crearIncidencia(titulo, descripcion, it.latitude, it.longitude)
                    }
                    showCreateDialog = false
                    titulo = ""
                    descripcion = ""
                }) { Text("Enviar") }
            }
        )
    }
}