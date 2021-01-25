package br.com.devmatheus.pokedex.features.pokemonnavigation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.devmatheus.pokedex.features.pokemonlistfavorite.PokemonListFavoriteFragment
import br.com.devmatheus.pokedex.features.pokemonlist.view.PokemonListFragment

class TabAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PokemonListFragment()
            1 -> PokemonListFavoriteFragment()
            else -> throw IllegalArgumentException("Invalid type $position")
        }

    }
}