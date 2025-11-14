package com.example.pokemon.ui.pokemon

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pokemon.viewmodel.PokemonViewModel

@Composable
fun PokemonListScreen(navController: NavController, pokemonViewModel: PokemonViewModel) {
    val pokemons by pokemonViewModel.pokemons.collectAsState()

    Column {
        LazyColumn(modifier = Modifier.padding(16.dp)) {
            items(pokemons) { pokemon ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { navController.navigate("pokemon_detail/${pokemon.id}") }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(pokemon.nome)
                        Text("Tipo: ${pokemon.tipo}")
                        Text("Nível: ${pokemon.nivel}")
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.popBackStack() }, modifier = Modifier.padding(16.dp)) {
            Text("Voltar")
        }
    }
}
