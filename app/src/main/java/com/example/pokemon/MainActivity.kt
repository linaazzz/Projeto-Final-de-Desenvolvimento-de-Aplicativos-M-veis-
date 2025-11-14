package com.example.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.pokemon.db.AppDatabase
import com.example.pokemon.network.PokeApiService
import com.example.pokemon.repository.AuthRepository
import com.example.pokemon.repository.PokemonRepository
import com.example.pokemon.ui.NavGraph
import com.example.pokemon.viewmodel.AuthViewModel
import com.example.pokemon.viewmodel.PokemonViewModel
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar Room
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "pokemon-db"
        ).build()

        // Inicializar Retrofit
        val api = PokeApiService.create()

        // Criar Repositórios
        val pokemonRepo = PokemonRepository(db.pokemonDao(), api)
        val authRepo = AuthRepository(FirebaseAuth.getInstance())

        // Criar ViewModels
        val pokemonViewModel = PokemonViewModel(pokemonRepo)
        val authViewModel = AuthViewModel(authRepo)

        // Configurar Compose e NavController
        setContent {
            val navController = rememberNavController()
            MaterialTheme {
                Surface {
                    NavGraph(
                        navController = navController,
                        pokemonViewModel = pokemonViewModel,
                        authViewModel = authViewModel
                    )
                }
            }
        }
    }
}
