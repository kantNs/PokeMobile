package com.github.vincebrees.pokemonlist.data.repository

import com.github.vincebrees.pokemonlist.domain.Pokemon
import io.reactivex.Single

/*
        Simple méthode permettant de renvoyer la liste de Pokemons
 */

interface PokemonRepository{

    fun getPokemonList() : Single<List<Pokemon>>
}