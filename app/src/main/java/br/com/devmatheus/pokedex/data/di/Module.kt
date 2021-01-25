package br.com.devmatheus.pokedex.data.di

import androidx.room.Room
import br.com.devmatheus.pokedex.BuildConfig
import br.com.devmatheus.pokedex.features.pokemonlist.repository.PokemonListRepository
import br.com.devmatheus.pokedex.features.pokemonlist.repository.PokemonListService
import br.com.devmatheus.pokedex.features.pokemonlist.viewmodel.PokemonListViewModel
import br.com.devmatheus.pokedex.data.client.PokedexAPI
import br.com.devmatheus.pokedex.data.client.RetrofitClient
import br.com.devmatheus.pokedex.data.db.database.PokemonDatabase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    single {
        RetrofitClient().createWebService<PokedexAPI>(
            okHttpClient = RetrofitClient().createHttpClient(),
            baseUrl = BuildConfig.BASE_POKEDEX_URL
        )
    }
    single {
        Room.databaseBuilder(
            get(),
            PokemonDatabase::class.java,
            "database.db")
            .build()
    }
    single { get<PokemonDatabase>().DAO() }
    factory<PokemonListService> { PokemonListRepository(api = get()) }
    viewModel { PokemonListViewModel(repository = get(), database = get()) }
}