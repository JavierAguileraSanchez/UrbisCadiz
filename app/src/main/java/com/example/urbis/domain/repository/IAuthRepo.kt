package com.example.urbis.domain.repository

interface IAuthRepo {
    suspend fun login(email: String, pass: String): Result<Unit>
    suspend fun register(email: String, pass: String, nombre: String, rol: String): Result<Unit>
    fun getCurrentUserUid(): String?
    fun logout()
}