package com.example.pokemon.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pokemon.ui.login.LoginScreen
import com.example.pokemon.ui.main.MainScreen
import com.example.pokemon.ui.pokemon.PokemonDetailScreen
import com.example.pokemon.ui.pokemon.PokemonListScreen
import com.example.pokemon.ui.pokemon.PokemonFormScreen
import com.example.pokemon.ui.search.PokemonSearchScreen
import com.example.pokemon.viewmodel.AuthViewModel
import com.example.pokemon.viewmodel.PokemonViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    pokemonViewModel: PokemonViewModel,
    authViewModel: AuthViewModel
) {
    NavHost(navController, startDestination = "login") {

        composable("login") {
            LoginScreen(navController, authViewModel)
        }

        composable("main") {
            MainScreen(navController)
        }

        composable("pokemon_list") {
            PokemonListScreen(navController, pokemonViewModel)
        }

        composable("pokemon_detail/{pokemonId}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("pokemonId")?.toInt() ?: 0
            PokemonDetailScreen(navController, id, pokemonViewModel)
        }

        composable("pokemon_form/{pokemonId}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("pokemonId")?.toInt() ?: 0
            PokemonFormScreen(navController, id, pokemonViewModel)
        }

        composable("pokemon_search") {
            PokemonSearchScreen(navController, pokemonViewModel)
        }
    }
}
