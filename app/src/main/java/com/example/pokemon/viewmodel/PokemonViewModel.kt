package com.example.pokemon.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.model.Pokemon
import com.example.pokemon.repository.PokemonRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PokemonViewModel(private val repo: PokemonRepository) : ViewModel() {

    val pokemons = repo.getAllPokemons().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addPokemon(pokemon: Pokemon) = viewModelScope.launch { repo.insert(pokemon) }
    fun updatePokemon(pokemon: Pokemon) = viewModelScope.launch { repo.update(pokemon) }
    fun deletePokemon(pokemon: Pokemon) = viewModelScope.launch { repo.delete(pokemon) }
    suspend fun fetchPokemonOnline(nome: String) = repo.fetchPokemonOnline(nome)
}
