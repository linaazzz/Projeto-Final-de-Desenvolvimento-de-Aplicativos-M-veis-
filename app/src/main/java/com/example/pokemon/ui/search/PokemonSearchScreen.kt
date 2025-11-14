package com.example.pokemon.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pokemon.viewmodel.PokemonViewModel
import kotlinx.coroutines.launch

@Composable
fun PokemonSearchScreen(navController: NavController, pokemonViewModel: PokemonViewModel) {
    var searchName by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = searchName, onValueChange = { searchName = it }, label = { Text("Nome do Pokémon") })
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            scope.launch {
                try {
                    val pokemonResponse = pokemonViewModel.fetchPokemonOnline(searchName.lowercase())
                    val tipo = pokemonResponse.types.joinToString { it.type.name }
                    result = "Nome: ${pokemonResponse.name}\nTipo: $tipo"
                } catch (e: Exception) {
                    result = "Pokémon não encontrado"
                }
            }
        }) { Text("Buscar") }
        Spacer(modifier = Modifier.height(16.dp))
        result?.let { Text(it) }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.popBackStack() }) { Text("Voltar") }
    }
}

