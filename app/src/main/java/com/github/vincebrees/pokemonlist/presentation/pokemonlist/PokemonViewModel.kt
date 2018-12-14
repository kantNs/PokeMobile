package com.github.vincebrees.pokemonlist.presentation.pokemonlist

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.github.vincebrees.pokemonlist.data.repository.PokemonRepository
import com.github.vincebrees.pokemonlist.di.PokemonApplication
import com.github.vincebrees.pokemonlist.domain.Pokemon
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/*  Le ViewModel travaille avec le DataModel pour récupérer et sauvegarder les données.
C'est le package compositeDisposable qui va s'en occuper  */

class PokemonViewModel : ViewModel(), LifecycleObserver {

    @Inject
    lateinit var pokemonRepository: PokemonRepository

    private val compositeDisposable = CompositeDisposable()

    var liveDataListPokemon: MutableLiveData<List<Pokemon>> = MutableLiveData()

    init {
        initializeDagger()

        val disposable = pokemonRepository.getPokemonList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list -> liveDataListPokemon.value = list
            }, { t: Throwable? ->

                t!!.printStackTrace()
            })

        compositeDisposable.add(disposable)

    }

    private fun initializeDagger() = PokemonApplication.appComponent.inject(this)
}