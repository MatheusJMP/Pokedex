package br.com.devmatheus.pokedex.features.pokemonlist.repository

import br.com.devmatheus.pokedex.data.model.CustomResponse
import br.com.devmatheus.pokedex.data.model.PokedexResponse
import br.com.devmatheus.pokedex.data.model.PokemonDetailResponse

interface PokemonListService{
    suspend fun getListPokemon() : CustomResponse<PokedexResponse>
    suspend fun getDetailPokemon(url: String) : CustomResponse<PokemonDetailResponse>
    suspend fun getNextPage(url: String) : CustomResponse<PokedexResponse>
}