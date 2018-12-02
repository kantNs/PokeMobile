package com.github.vincebrees.pokemonlist.data.repository

import com.github.vincebrees.pokemonlist.domain.Pokemon
import io.reactivex.Single

/**
 * Created by Vincent ETIENNE on 19/11/2018.
 */

interface PokemonRepository{

    fun getPokemonList() : Single<List<Pokemon>>
}