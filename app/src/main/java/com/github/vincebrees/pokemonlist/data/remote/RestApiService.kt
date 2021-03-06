package com.github.vincebrees.pokemonlist.data.remote

import com.github.vincebrees.pokemonlist.data.pojo.RestPokemonData
import com.github.vincebrees.pokemonlist.domain.Pokemon
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path



interface RestApiService{

    @GET("pokedex.json")
    fun getListPokemon(): Single<Response<RestPokemonData>>


}