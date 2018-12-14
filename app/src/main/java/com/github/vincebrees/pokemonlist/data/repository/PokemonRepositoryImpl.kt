package com.github.vincebrees.pokemonlist.data.repository

import com.github.vincebrees.pokemonlist.data.pojo.RestPokemonData
import com.github.vincebrees.pokemonlist.data.remote.RestApiService
import com.github.vincebrees.pokemonlist.domain.Pokemon
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton



@Singleton
class PokemonRepositoryImpl @Inject constructor(
    private val restApiService: RestApiService
): PokemonRepository{

    override fun getPokemonList(): Single<List<Pokemon>> {
        return restApiService.getListPokemon()
            .map{
                    response -> if(response.isSuccessful && response.body() != null){
                response.body()?.pokemon
                }else{
                null
                }
            }
    }
}