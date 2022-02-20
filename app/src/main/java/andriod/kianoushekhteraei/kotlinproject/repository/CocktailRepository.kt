package andriod.kianoushekhteraei.kotlinproject.repository

import andriod.kianoushekhteraei.kotlinproject.domain.model.Cocktail


interface CocktailRepository {

    suspend fun get() : List<Cocktail>

}