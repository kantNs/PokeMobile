package com.github.vincebrees.pokemonlist.data.pojo

import com.github.vincebrees.pokemonlist.domain.Pokemon

/*
    Class permettant de  créer et manipuler la liste de pokemons
    Cette méthode est la version Kotlin
 */


//New Way to have a Pojo with KOTLIN <3
data class RestPokemonData(
    val pokemon : List<Pokemon>
)