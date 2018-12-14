package com.github.vincebrees.pokemonlist.domain

import android.view.View

/*
    Interface permettant de créer un evenement lors d'un click sur un item
 */


interface ItemClickListener {
    fun onClick(view:View,position:Int)
}