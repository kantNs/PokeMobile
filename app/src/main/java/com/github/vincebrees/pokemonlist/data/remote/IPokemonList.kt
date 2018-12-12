package com.github.vincebrees.pokemonlist.data.remote

import com.github.vincebrees.pokemonlist.domain.Pokedex
import retrofit2.http.GET
import io.reactivex.Observable

interface IPokemonList {
    @get:GET("pokedex.json")
    val listPokemon:Observable<Pokedex>
}