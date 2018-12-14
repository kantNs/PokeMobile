package com.github.vincebrees.pokemonlist.presentation.pokemonlist.Adapter

import android.content.Context
import android.content.Intent
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.vincebrees.pokemonlist.R
import com.github.vincebrees.pokemonlist.domain.Common

import com.github.vincebrees.pokemonlist.domain.Evolution
import com.robertlevonyan.views.chip.Chip

/*
   L'Adapter permet de faire l'intermédiaire entre les données et la vue, ici il s'agit du nom des évolutions du pokemon
*/

class PokemonEvolutionAdapter(internal var context: Context, internal var evolutionList:List<Evolution>?):
    RecyclerView.Adapter<PokemonEvolutionAdapter.MyViewHolder>() {
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.chip.chipText = evolutionList!![position].name
        holder.chip.changeBackgroundColor(Common.getColorByType(Common.findPokemonByNum(evolutionList!![position].num!!)!!.type!![0]))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(context).inflate(R.layout.chip_item,parent,false)
        return MyViewHolder(itemView)
    }



    override fun getItemCount(): Int {
        return evolutionList!!.size
    }

    init {
        if (evolutionList == null) {
            evolutionList = ArrayList()
        }
    }


        inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            internal var chip: Chip

            init {
                chip = itemView.findViewById(R.id.chip) as Chip
                chip.setOnChipClickListener {

                    LocalBroadcastManager.getInstance(context)
                        .sendBroadcast(Intent(Common.KEY_NUM_EVOLUTION).putExtra("num", evolutionList!![adapterPosition].num))
                }
            }


        }

    }




