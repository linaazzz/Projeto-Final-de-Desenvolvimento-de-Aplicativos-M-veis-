package com.example.pokemon.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pokemon.repository.AuthRepository

class AuthViewModel(private val repo: AuthRepository) : ViewModel() {
    suspend fun register(email: String, senha: String) = repo.createUser(email, senha)
    suspend fun login(email: String, senha: String) = repo.login(email, senha)
    fun logout() = repo.logout()
}
