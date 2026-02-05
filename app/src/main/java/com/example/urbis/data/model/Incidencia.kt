package com.example.urbis.data.model

data class Incidencia(
    val id: String = "",
    val titulo: String = "",
    val descripcion: String = "",
    val latitud: Double = 0.0,
    val longitud: Double = 0.0,
    val imagenUrl: String? = null,
    val estado: String = "pendiente",
    val fecha: Long = System.currentTimeMillis()
) {
    constructor() : this("", "", "", 0.0, 0.0, null, "pendiente", 0L)
}