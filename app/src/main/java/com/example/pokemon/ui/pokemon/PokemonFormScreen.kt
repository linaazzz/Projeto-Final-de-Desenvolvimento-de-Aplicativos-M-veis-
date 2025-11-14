package com.example.pokemon.ui.pokemon

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pokemon.model.Pokemon
import com.example.pokemon.viewmodel.PokemonViewModel
import kotlinx.coroutines.launch

@Composable
fun PokemonFormScreen(navController: NavController, pokemonId: Int, pokemonViewModel: PokemonViewModel) {
    val scope = rememberCoroutineScope()
    val editingPokemon = pokemonViewModel.pokemons.value.find { it.id == pokemonId }

    var nome by remember { mutableStateOf(editingPokemon?.nome ?: "") }
    var tipo by remember { mutableStateOf(editingPokemon?.tipo ?: "") }
    var nivel by remember { mutableStateOf(editingPokemon?.nivel?.toString() ?: "") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = nome, onValueChange = { nome = it }, label = { Text("Nome") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = tipo, onValueChange = { tipo = it }, label = { Text("Tipo") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = nivel, onValueChange = { nivel = it }, label = { Text("Nível") })
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val p = Pokemon(id = editingPokemon?.id ?: 0, nome = nome, tipo = tipo, nivel = nivel.toIntOrNull() ?: 1)
            scope.launch {
                if (editingPokemon == null) pokemonViewModel.addPokemon(p)
                else pokemonViewModel.updatePokemon(p)
                navController.navigate("pokemon_list") { popUpTo("pokemon_list") { inclusive = true } }
            }
        }) {
            Text(if (editingPokemon == null) "Adicionar" else "Salvar")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.popBackStack() }) { Text("Voltar") }
    }
}
