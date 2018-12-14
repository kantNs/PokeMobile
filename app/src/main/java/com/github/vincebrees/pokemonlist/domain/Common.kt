package com.github.vincebrees.pokemonlist.domain

import android.graphics.Color

/*
       Implementation de plusieurs méthodes : Trouver un pokemon par son numéro
                                              Avoir la couleur associée au type
 */

object Common {

    var pokemonList:List<Pokemon> = ArrayList()
    val KEY_ENABLE_HOME = "position"
    val KEY_NUM_EVOLUTION = "evolution"

    fun findPokemonByNum(num: String?): Pokemon? {
        for(pokemon in Common.pokemonList)
            if(pokemon.num.equals(num))
                return pokemon
        return null

    }

    fun getColorByType(type: String): Int {
        when (type) {

            "Normal" -> return Color.parseColor("#A4A27A")


            "Dragon" -> return Color.parseColor("#743BFB")


            "Psy" -> return Color.parseColor("#F15B85")


            "Foudre" -> return Color.parseColor("#E9CA3C")


            "Sol" -> return Color.parseColor("#D9BF6C")


            "Plante" -> return Color.parseColor("#81C85B")

            "Poison" -> return Color.parseColor("#A441A3")

            "Acier" -> return Color.parseColor("#BAB7D2")


            "Fee" -> return Color.parseColor("#DDA2DF")


            "Feu" -> return Color.parseColor("#F48130")


            "Combat" -> return Color.parseColor("#BE3027")


            "Insecte" -> return Color.parseColor("#A8B822")


            "Spectre" -> return Color.parseColor("#705693")


            "Tenebre" -> return Color.parseColor("#745945")


            "Glace" -> return Color.parseColor("#9BD8D8")


            "Eau" -> return Color.parseColor("#658FF1")

            "Vol" -> return Color.parseColor("#658FF1")
            else -> return Color.parseColor("#658FA0")
        }
    }


}