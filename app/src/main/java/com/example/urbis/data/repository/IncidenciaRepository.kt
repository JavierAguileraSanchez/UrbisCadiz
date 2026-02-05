package com.example.urbis.data.repository

import android.net.Uri
import com.example.urbis.data.model.Incidencia
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import java.util.UUID

class IncidenciaRepository(private val db: FirebaseFirestore) {
    private val storage = FirebaseStorage.getInstance().reference

    suspend fun subirImagen(uri: Uri): String? {
        return try {
            val ref = storage.child("fotos/${UUID.randomUUID()}.jpg")
            val metadata = com.google.firebase.storage.storageMetadata {
                contentType = "image/jpeg"
            }
            ref.putFile(uri, metadata).await()
            ref.downloadUrl.await().toString()
        } catch (e: Exception) { null }
    }

    suspend fun guardarIncidencia(incidencia: Incidencia) {
        val docRef = db.collection("incidencias").document()
        val conId = incidencia.copy(id = docRef.id)
        docRef.set(conId).await()
    }

    suspend fun actualizarIncidencia(incidencia: Incidencia) {
        db.collection("incidencias").document(incidencia.id).set(incidencia).await()
    }

    suspend fun getUserRole(uid: String): String {
        return try {
            val doc = db.collection("usuarios").document(uid).get().await()
            doc.getString("role") ?: "usuario"
        } catch (e: Exception) { "usuario" }
    }

    fun getAllIncidencias(): Flow<List<Incidencia>> = callbackFlow {
        val listener = db.collection("incidencias")
            .orderBy("fecha", Query.Direction.DESCENDING)
            .addSnapshotListener { s, _ -> trySend(s?.toObjects(Incidencia::class.java) ?: emptyList()) }
        awaitClose { listener.remove() }
    }

    fun getIncidenciasAprobadas(): Flow<List<Incidencia>> = callbackFlow {
        val listener = db.collection("incidencias")
            .whereEqualTo("estado", "aprobada")
            .addSnapshotListener { s, _ -> trySend(s?.toObjects(Incidencia::class.java) ?: emptyList()) }
        awaitClose { listener.remove() }
    }
}