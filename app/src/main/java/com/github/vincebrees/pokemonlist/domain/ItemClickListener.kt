package com.github.vincebrees.pokemonlist.domain

import android.view.View

interface ItemClickListener {
    fun onClick(view:View,position:Int)
}