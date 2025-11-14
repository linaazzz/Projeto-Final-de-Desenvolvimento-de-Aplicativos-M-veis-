package com.example.pokemon.repository

import com.google.firebase.auth.FirebaseAuth

class AuthRepository(private val auth: FirebaseAuth) {
    suspend fun createUser(email: String, senha: String) = auth.createUserWithEmailAndPassword(email, senha)
    suspend fun login(email: String, senha: String) = auth.signInWithEmailAndPassword(email, senha)
    fun logout() = auth.signOut()
}
