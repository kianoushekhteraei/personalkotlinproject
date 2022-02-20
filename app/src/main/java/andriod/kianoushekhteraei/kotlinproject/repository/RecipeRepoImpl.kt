package andriod.kianoushekhteraei.kotlinproject.repository

import andriod.kianoushekhteraei.kotlinproject.domain.model.Recipe
import andriod.kianoushekhteraei.kotlinproject.network.base.ShopFrgServices
import andriod.kianoushekhteraei.kotlinproject.network.model.RecipeDtoMapper


class RecipeRepoImpl (
    private val shopFrgServices: ShopFrgServices,
    private val mapper: RecipeDtoMapper,
): RecipeRepository {

    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(shopFrgServices.search(token = token, page = page, query = query).recipes)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(shopFrgServices.get(token = token, id))
    }

}