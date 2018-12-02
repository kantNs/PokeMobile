package com.github.vincebrees.pokemonlist.data.pojo

import com.github.vincebrees.pokemonlist.domain.Pokemon

/**
 * Created by Vincent ETIENNE on 26/11/2018.
 */

//New Way to have a Pojo with KOTLIN <3
data class RestPokemonData(
    val count : Int,
    val next : Int,
    val previous : Int,
    val results : List<Pokemon>
)