package andriod.kianoushekhteraei.kotlinproject.repository

import andriod.kianoushekhteraei.kotlinproject.domain.model.Product
import andriod.kianoushekhteraei.kotlinproject.network.base.CategoryFrgServices
import andriod.kianoushekhteraei.kotlinproject.network.model.ProductDtoMapper

class ProductRepoImpl(


    private val categoryFrgServices: CategoryFrgServices,
    private val mapper: ProductDtoMapper,
) : ProductRepository {


    override suspend fun get(): List<Product> {

        return mapper.toDomainList(categoryFrgServices.get())

    }


}