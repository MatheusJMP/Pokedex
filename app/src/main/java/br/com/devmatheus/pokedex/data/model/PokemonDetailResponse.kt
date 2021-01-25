package br.com.devmatheus.pokedex.data.model

data class PokemonDetailResponse(
    val id: Int,
    val types: List<PokemonType>,
    val name: String,
    val sprites: PokemonImageResponse
)

data class PokemonType(
    val type: Type
)

data class Type(
    val name: String
)

data class PokemonImageResponse(
    val front_default: String,
    val back_default: String
)