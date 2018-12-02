package com.github.vincebrees.pokemonlist.di

import com.github.vincebrees.pokemonlist.presentation.pokemonlist.PokemonViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, RemoteModule::class])
@Singleton
interface AppComponent {

  fun inject(viewModel: PokemonViewModel)

}