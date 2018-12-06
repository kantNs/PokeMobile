package com.github.vincebrees.pokemonlist.presentation.pokemonlist

import android.content.Context
import android.content.Intent
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.bumptech.glide.Glide
import com.github.vincebrees.pokemonlist.R
import com.github.vincebrees.pokemonlist.domain.Common
import com.github.vincebrees.pokemonlist.domain.ItemClickListener
import com.github.vincebrees.pokemonlist.domain.Pokemon
import kotlinx.android.synthetic.main.pokemon_view_holder.view.*
import javax.sql.CommonDataSource

/**
 * Created by Vincent ETIENNE on 19/11/2018.
 */

class PokemonAdapter(val context: Context, var listModel: List<Pokemon>) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_view_holder, parent, false)
        return ViewHolder(context, itemView)
    }

    override fun getItemCount() = listModel.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.bindItem(listModel[position])
        holder.setitemClickListener(object: ItemClickListener{
            override fun onClick(view: View, position: Int) {
                //Toast.makeText(context,listModel[position].name ,LENGTH_SHORT)
                 ///   .show();
                LocalBroadcastManager.getInstance(context)
                   .sendBroadcast(Intent(Common.KEY_ENABLE_HOME).putExtra("position",position))

            }

        })
    }


    class ViewHolder(val context: Context, itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var itemClickListener: ItemClickListener?=null
        fun setitemClickListener(itemClickListener: ItemClickListener){
            this.itemClickListener=itemClickListener
        }



        fun bindItem(model: Pokemon) {
            with(itemView) {
                item_pokemon_name.text = model.name
                Glide.with(context)
                    .load(model.img)
                    .into(item_pokemon_img);
                itemView.setOnClickListener {
                    view ->
                    itemClickListener!!.onClick(view,adapterPosition)
                }
                    //Toast.makeText(context, model.name,LENGTH_SHORT).show();
                    //
            }
        }
    }
}
