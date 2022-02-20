package andriod.kianoushekhteraei.kotlinproject.repository

import andriod.kianoushekhteraei.kotlinproject.domain.model.Cocktail
import andriod.kianoushekhteraei.kotlinproject.network.base.HomeFrgServices
import andriod.kianoushekhteraei.kotlinproject.network.model.CocktailDtoMapper

class CocktailRepoImpl(

    private val homeFrgServices: HomeFrgServices,
    private val mapper: CocktailDtoMapper,

)  : CocktailRepository {

    override suspend fun get(): List<Cocktail> {

        return mapper.toDomainList(homeFrgServices.get().drinks)
    }
}