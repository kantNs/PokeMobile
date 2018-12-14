package com.github.vincebrees.pokemonlist.di

import android.app.Application



class PokemonApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .remoteModule(RemoteModule())
            .build()
    }
}