package com.example.pokemon.ui.pokemon

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pokemon.viewmodel.PokemonViewModel

@Composable
fun PokemonDetailScreen(navController: NavController, pokemonId: Int, pokemonViewModel: PokemonViewModel) {
    val pokemon by remember { derivedStateOf { pokemonViewModel.pokemons.value.find { it.id == pokemonId } } }

    pokemon?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Nome: ${it.nome}", style = MaterialTheme.typography.titleLarge)
            Text("Tipo: ${it.tipo}")
            Text("Nível: ${it.nivel}")
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Button(onClick = { navController.navigate("pokemon_form/${it.id}") }) { Text("Editar") }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = {
                    pokemonViewModel.deletePokemon(it)
                    navController.navigate("pokemon_list") { popUpTo("pokemon_list") { inclusive = true } }
                }) { Text("Excluir") }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.popBackStack() }) { Text("Voltar") }
        }
    } ?: Text("Pokémon não encontrado", modifier = Modifier.padding(16.dp))
}
