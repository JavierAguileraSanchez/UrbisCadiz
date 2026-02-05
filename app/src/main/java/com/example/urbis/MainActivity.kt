package com.example.urbis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.urbis.data.repository.AuthRepository
import com.example.urbis.data.repository.IncidenciaRepository
import com.example.urbis.ui.navigation.NavGraph
import com.example.urbis.ui.viewmodel.AuthViewModel
import com.example.urbis.ui.viewmodel.AuthViewModelFactory
import com.example.urbis.ui.viewmodel.MapViewModel
import com.example.urbis.ui.viewmodel.MapViewModelFactory
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inicializamos Firebase una sola vez
        val auth = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()

        // 2. Creamos los repositorios
        val authRepository = AuthRepository(auth, db)
        val incidenciaRepository = IncidenciaRepository(db)

        setContent {
            val navController = rememberNavController()

            // 3. Creamos los ViewModels usando sus Factories
            // Esto asegura que se mantengan vivos durante toda la app
            val authViewModel: AuthViewModel = viewModel(
                factory = AuthViewModelFactory(authRepository)
            )
            val mapViewModel: MapViewModel = viewModel(
                factory = MapViewModelFactory(incidenciaRepository)
            )

            // 4. Llamamos al NavGraph
            NavGraph(
                navController = navController,
                authViewModel = authViewModel,
                mapViewModel = mapViewModel
            )
        }
    }
}