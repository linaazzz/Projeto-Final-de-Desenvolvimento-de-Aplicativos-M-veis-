package com.example.pokemon.repository

import com.example.pokemon.db.PokemonDao
import com.example.pokemon.model.Pokemon
import com.example.pokemon.network.PokeApiService
import kotlinx.coroutines.flow.Flow

class PokemonRepository(
    private val dao: PokemonDao,
    private val api: PokeApiService
) {
    fun getAllPokemons(): Flow<List<Pokemon>> = dao.getAll()
    suspend fun insert(pokemon: Pokemon) = dao.insert(pokemon)
    suspend fun update(pokemon: Pokemon) = dao.update(pokemon)
    suspend fun delete(pokemon: Pokemon) = dao.delete(pokemon)

    suspend fun fetchPokemonOnline(nome: String) = api.getPokemon(nome)
}
