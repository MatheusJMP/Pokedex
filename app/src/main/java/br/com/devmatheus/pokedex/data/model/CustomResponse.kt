package br.com.devmatheus.pokedex.data.model

sealed class CustomResponse<out T : Any> {
    class Success<out T : Any>(val data: T) : CustomResponse<T>()
    class Error(val exception: Throwable) : CustomResponse<Nothing>()
}