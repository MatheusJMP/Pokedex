package br.com.devmatheus.pokedex.features.pokemonlist.repository

import br.com.devmatheus.pokedex.data.client.PokedexAPI
import br.com.devmatheus.pokedex.data.model.CustomResponse
import br.com.devmatheus.pokedex.data.model.PokedexResponse
import br.com.devmatheus.pokedex.data.model.PokemonDetailResponse

class PokemonListRepository(private val api: PokedexAPI) : PokemonListService {

    override suspend fun getListPokemon(): CustomResponse<PokedexResponse> {
        return try {
            val result = api.getPokemons()
            CustomResponse.Success(result)
        } catch (e: Exception) {
            CustomResponse.Error(e)
        }
    }

    override suspend fun getDetailPokemon(url: String): CustomResponse<PokemonDetailResponse> {
        return try {
            val result = api.getPokemonDetail(url)
            CustomResponse.Success(result)
        } catch (e: Exception) {
            CustomResponse.Error(e)
        }
    }

    override suspend fun getNextPage(url: String): CustomResponse<PokedexResponse> {
        return try {
            val result = api.getPokemonsNextPage(url)
            CustomResponse.Success(result)
        } catch (e: Exception) {
            CustomResponse.Error(e)
        }
    }
}