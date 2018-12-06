package com.github.vincebrees.pokemonlist.presentation.pokemonlist


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.github.vincebrees.pokemonlist.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class PokemonDetail : Fragment() {
    companion object {
        internal var instance:PokemonDetail?=null

        fun getInstance():PokemonDetail{
            if(instance == null){
                instance =PokemonDetail()
            }
            return instance!!
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val itemView:View= inflater.inflate(R.layout.fragment_pokemon_detail, container, false)
        return itemView
    }


}
