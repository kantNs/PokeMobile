package com.github.vincebrees.pokemonlist.domain

/*
       Objet Pokemon avec ses attributs correspondant à ceux de l'API
 */

data class Pokemon(
    val name: String,
    val url: String,
    val id: Number,
    val num: String,
    val img: String,
    val type: List<String>,
    val height: String,
    val weight: String,
    val candy: String,
    val candy_count: Number,
    val egg: String,
    val spawn_chance: Double,
    val avg_spawns: Double,
    val spawn_time: String,
    val multipliers: List<Double?>,
    val weaknesses: List<String>,
    val next_evolution:List<Evolution>,
    val prev_evolution:List<Evolution>
)