package andriod.kianoushekhteraei.kotlinproject.network.base

import andriod.kianoushekhteraei.kotlinproject.domain.model.Product
import andriod.kianoushekhteraei.kotlinproject.network.model.ProductDto
import retrofit2.Call
import retrofit2.http.GET


interface CategoryFrgServices {

    // for connecting with mvvm arch
    @GET("products")
    suspend fun get(
    ) :  List<ProductDto>

    // for direct connecting in activity or fragment
    @GET("products")
    fun getProducts(): Call<List<Product>>
}