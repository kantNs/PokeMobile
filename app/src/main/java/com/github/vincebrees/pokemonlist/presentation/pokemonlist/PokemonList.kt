package com.github.vincebrees.pokemonlist.presentation.pokemonlist


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.github.vincebrees.pokemonlist.R
import com.github.vincebrees.pokemonlist.data.remote.IPokemonList
import com.github.vincebrees.pokemonlist.di.RetrofitClient
import com.github.vincebrees.pokemonlist.domain.Common
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_pokemon_list.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class PokemonList : Fragment() {

    internal var compositeDisposable = CompositeDisposable()
    internal lateinit var recycler_view:RecyclerView
    internal var iPokemonList:IPokemonList

    init {
         val retrofit = RetrofitClient.instance
         iPokemonList=retrofit.create(IPokemonList::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val itemView = inflater.inflate(R.layout.fragment_pokemon_list, container, false)

        recycler_view.findViewById(R.id.pokemon_recyclerview) as RecyclerView
        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = GridLayoutManager(activity,2)
        val itemDecoration = itemOffsetDecoration(activity!!,R.dimen.spacing)
        recycler_view.addItemDecoration(itemDecoration)

        fetchData()

        return itemView
    }

    private fun fetchData(){
        compositeDisposable.add(iPokemonList.listPokemon
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { pokemonDex ->
                Common.pokemonList = pokemonDex.pokemon!!
                val adapter = PokemonAdapter(activity!!,Common.pokemonList)
                recycler_view.adapter = adapter
            }



        );
    }

}
