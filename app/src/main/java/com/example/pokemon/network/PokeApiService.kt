package com.example.pokemon.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

data class PokemonResponse(
    val name: String,
    val types: List<TypeInfo>
)

data class TypeInfo(val type: TypeName)
data class TypeName(val name: String)

interface PokeApiService {
    @GET("pokemon/{nome}")
    suspend fun getPokemon(@Path("nome") nome: String): PokemonResponse

    companion object {
        fun create(): PokeApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(PokeApiService::class.java)
        }
    }
}
