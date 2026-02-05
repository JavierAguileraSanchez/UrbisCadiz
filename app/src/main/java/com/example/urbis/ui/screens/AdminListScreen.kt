package com.example.urbis.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.urbis.data.model.Incidencia
import com.example.urbis.ui.viewmodel.MapViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminListScreen(
    navController: NavHostController,
    mapViewModel: MapViewModel
) {
    // 1. CARGA DE DATOS: Sincronizado con el nombre definitivo del ViewModel
    LaunchedEffect(Unit) {
        mapViewModel.cargarDatos()
    }

    val incidencias = mapViewModel.listaIncidencias

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Gestión de Incidencias (Admin)") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { padding ->
        if (incidencias.isEmpty()) {
            Box(Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                Text("No hay incidencias registradas en el sistema")
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(padding),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(incidencias) { incidencia ->
                    IncidenciaItem(
                        incidencia = incidencia,
                        onApprove = {
                            // 2. ACCIÓN: Sincronizado con cambiarEstado del ViewModel
                            mapViewModel.cambiarEstado(incidencia, "aprobada")
                        },
                        onViewOnMap = {
                            // 3. NAVEGACIÓN: Sincronizado con los argumentos del NavGraph
                            navController.navigate("mapa?lat=${incidencia.latitud}&lng=${incidencia.longitud}")
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun IncidenciaItem(
    incidencia: Incidencia,
    onApprove: () -> Unit,
    onViewOnMap: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(incidencia.titulo, style = MaterialTheme.typography.titleMedium)
                    Text(
                        text = incidencia.estado.uppercase(),
                        color = if (incidencia.estado == "aprobada") Color(0xFF4CAF50) else Color.Gray,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
                // Botón para ir al mapa y ver dónde está el problema
                IconButton(onClick = onViewOnMap) {
                    Icon(Icons.Default.LocationOn, contentDescription = "Ver en mapa", tint = Color.Red)
                }
            }

            // Imagen de la incidencia (si existe)
            if (!incidencia.imagenUrl.isNullOrBlank()) {
                Spacer(Modifier.height(8.dp))
                AsyncImage(
                    model = incidencia.imagenUrl,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(Modifier.height(8.dp))
            Text(incidencia.descripcion, style = MaterialTheme.typography.bodyMedium)

            // Espaciador y botón de aprobación (solo si está pendiente)
            if (incidencia.estado != "aprobada") {
                Spacer(Modifier.height(12.dp))
                Button(
                    onClick = onApprove,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
                ) {
                    Icon(Icons.Default.Check, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text("Aprobar Incidencia")
                }
            }
        }
    }
}