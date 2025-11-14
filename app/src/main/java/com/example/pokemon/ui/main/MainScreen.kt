package com.example.pokemon.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainScreen(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = { navController.navigate("pokemon_list") }, modifier = Modifier.fillMaxWidth()) {
            Text("Meus Pokémons")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate("pokemon_form/0") }, modifier = Modifier.fillMaxWidth()) {
            Text("Adicionar Pokémon")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navController.navigate("pokemon_search") }, modifier = Modifier.fillMaxWidth()) {
            Text("Buscar na PokéAPI")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.popBackStack() }) { Text("Voltar") }
    }
}
