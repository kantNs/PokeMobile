package com.github.vincebrees.pokemonlist.domain

object Common {
    fun findPokemonByNum(num: String?): Pokemon? {
        for(pokemon in Common.pokemonList)
            if(pokemon.num.equals(num))
                return pokemon
        return null

    }


    var pokemonList:List<Pokemon> = ArrayList()
    val KEY_ENABLE_HOME = "position"
    val KEY_NUM_EVOLUTION = "evolution"
}
