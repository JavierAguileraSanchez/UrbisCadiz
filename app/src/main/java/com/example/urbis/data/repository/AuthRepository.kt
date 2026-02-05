package com.example.urbis.data.repository

import com.example.urbis.domain.repository.IAuthRepo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class AuthRepository(
    private val auth: FirebaseAuth,
    private val db: FirebaseFirestore
) : IAuthRepo {

    override suspend fun login(email: String, pass: String): Result<Unit> {
        return try {
            auth.signInWithEmailAndPassword(email, pass).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun register(email: String, pass: String, nombre: String, rol: String): Result<Unit> {
        return try {
            // 1. Creamos el usuario en Auth
            val result = auth.createUserWithEmailAndPassword(email, pass).await()
            val uid = result.user?.uid ?: throw Exception("Error al crear usuario")

            // 2. Guardamos sus datos extra (como el ROL) en Firestore
            val userMap = hashMapOf(
                "uid" to uid,
                "nombre" to nombre,
                "email" to email,
                "role" to rol // "Usuario" o "GESTOR"
            )
            db.collection("usuarios").document(uid).set(userMap).await()

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun getCurrentUserUid(): String? = auth.currentUser?.uid

    override fun logout() = auth.signOut()
}