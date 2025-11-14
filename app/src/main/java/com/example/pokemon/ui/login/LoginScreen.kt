package com.example.pokemon.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pokemon.viewmodel.AuthViewModel
import kotlinx.coroutines.launch
@Composable
fun LoginScreen(navController: NavController, authViewModel: AuthViewModel) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = email, onValueChange = { email = it }, label = { Text("Email") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = senha, onValueChange = { senha = it }, label = { Text("Senha") })
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            scope.launch {
                try {
                    authViewModel.login(email, senha)
                    navController.navigate("main") {
                        popUpTo("login") { inclusive = true }
                    }
                } catch (e: Exception) {
                    // Tratar erro de login
                }
            }
        }) { Text("Login") }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.popBackStack() }) { Text("Voltar") }
    }
}
