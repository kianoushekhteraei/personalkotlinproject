package andriod.kianoushekhteraei.kotlinproject.repository

import andriod.kianoushekhteraei.kotlinproject.domain.model.Product

interface ProductRepository {


   suspend fun get(): List<Product>

}