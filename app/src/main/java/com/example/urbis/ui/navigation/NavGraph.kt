package com.example.urbis.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.urbis.ui.screens.*
import com.example.urbis.ui.viewmodel.AuthViewModel
import com.example.urbis.ui.viewmodel.MapViewModel

@Composable
fun NavGraph(navController: NavHostController, authViewModel: AuthViewModel, mapViewModel: MapViewModel) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController, authViewModel) }
        composable("register") { RegisterScreen(navController, authViewModel) }
        composable(
            route = "mapa?lat={lat}&lng={lng}",
            arguments = listOf(
                navArgument("lat") { type = NavType.StringType; defaultValue = "36.5271 " },
                navArgument("lng") { type = NavType.StringType; defaultValue = "-6.2886" }
            )
        ) { backStackEntry ->
            val lat = backStackEntry.arguments?.getString("lat")?.toDoubleOrNull() ?: 36.5271
            val lng = backStackEntry.arguments?.getString("lng")?.toDoubleOrNull() ?: -6.2886
            MapScreen(navController, mapViewModel, authViewModel, lat, lng)
        }
        composable("admin_list") { AdminListScreen(navController, mapViewModel) }
    }
}