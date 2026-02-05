package com.example.urbis.ui.navigation

sealed class Screens(val route: String) {
    object Login : Screens("login")
    object Register : Screens("register")
    object Map : Screens("map")
}