package com.github.vincebrees.pokemonlist.presentation.pokemonlist.Activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.github.vincebrees.pokemonlist.R
import com.github.vincebrees.pokemonlist.domain.Common
import com.github.vincebrees.pokemonlist.domain.Pokemon
import com.github.vincebrees.pokemonlist.presentation.pokemonlist.Adapter.PokemonAdapter
import com.github.vincebrees.pokemonlist.presentation.pokemonlist.Fragment.PokemonDetail
import com.github.vincebrees.pokemonlist.presentation.pokemonlist.PokemonViewModel
import kotlinx.android.synthetic.main.activity_pokemon_list.*

/*
    Main activity qui se lance au début de l'appli, c'est ici que l'appli va savoir quel layout afficher en premier
 */

class PokemonListActivity : AppCompatActivity() {

    private lateinit var viewModel: PokemonViewModel
    var pokeList:List<Pokemon> = ArrayList()


    //Broadcast Handle
    private val showDetail = object:BroadcastReceiver(){

        override fun onReceive(p0: Context?, intent: Intent?) {
            if(intent!!.action!!.toString() == Common.KEY_ENABLE_HOME)
            {
                supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                supportActionBar!!.setDisplayShowHomeEnabled(true)

                //Replacement Fragment
                val detailFragment=
                    PokemonDetail.getInstance()
                val position=intent.getIntExtra("position",-1)
                val bundle=Bundle()
                bundle.putInt("position",position)
                detailFragment.arguments=bundle

                val fragmentTransaction= supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.constlayout,detailFragment)
                fragmentTransaction.addToBackStack("detail")
                fragmentTransaction.commit()

                // toolbar avec nom pokemon
                val pokemon=pokeList[position]
                toolbar.setTitle(pokemon.name)
            }
        }

    }
    private val showEvolution = object:BroadcastReceiver(){

        override fun onReceive(p0: Context?, intent: Intent?) {
            if(intent!!.action!!.toString() == Common.KEY_NUM_EVOLUTION)
            {

                //Replacement Fragment
                val detailFragment=
                    PokemonDetail.getInstance()
                val bundle=Bundle()
                val num =intent.getStringExtra("num")
                bundle.putString("num",num)
                detailFragment.arguments=bundle

                val fragmentTransaction= supportFragmentManager.beginTransaction()
                fragmentTransaction.remove(detailFragment)
                fragmentTransaction.replace(R.id.constlayout,detailFragment)
                fragmentTransaction.addToBackStack("detail")
                fragmentTransaction.commit()

                // toolbar avec nom pokemon
                val pokemon=Common.findPokemonByNum(num)
                toolbar.setTitle(pokemon!!.name)
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)
        initViewModel()
        initObserver()
        toolbar.setTitle("Pokedex 1ère Génération")
        setSupportActionBar(toolbar)

        //enregistrer le broadcast
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(showDetail, IntentFilter(Common.KEY_ENABLE_HOME))
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(showEvolution, IntentFilter(Common.KEY_NUM_EVOLUTION))
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            android.R.id.home ->{
                toolbar.title ="Liste de Pokemon"
                //pour nettoyer tous les fragment aux noms detail dans la pile
                supportFragmentManager.popBackStack("detail",FragmentManager.POP_BACK_STACK_INCLUSIVE)

                supportActionBar!!.setDisplayHomeAsUpEnabled(false)
                supportActionBar!!.setDisplayShowHomeEnabled(false)
            }
        }
        return true
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this).get(PokemonViewModel::class.java)
        viewModel.let { lifecycle.addObserver(it) }
    }

    private fun initObserver() {
        viewModel.liveDataListPokemon.observe(this, Observer {
            list -> if(list != null){
                        setupRecyclerView(list)
                        pokeList=list
                        Common.pokemonList=list
                    }

        })
    }

    private fun setupRecyclerView(list: List<Pokemon>) {
        val linearLayoutManager = LinearLayoutManager(this)
        recycler_list_pokemon.layoutManager = linearLayoutManager
        recycler_list_pokemon.adapter =
                PokemonAdapter(this, list)
        val dividerItemDecoration = DividerItemDecoration(recycler_list_pokemon.context, linearLayoutManager.orientation)
        recycler_list_pokemon.addItemDecoration(dividerItemDecoration)
    }
}
