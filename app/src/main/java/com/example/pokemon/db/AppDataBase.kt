package com.example.pokemon.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokemon.model.Pokemon

@Database(entities = [Pokemon::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}
