package andriod.kianoushekhteraei.kotlinproject.network.base

import andriod.kianoushekhteraei.kotlinproject.domain.model.ImgSlider
import andriod.kianoushekhteraei.kotlinproject.network.response.CocktailSearchResponse
import retrofit2.Call
import retrofit2.http.GET

interface HomeFrgServices {

    // for connecting with mvvm arch
    @GET("wp-json/wp/v2/posts?per_page=100&context=embed")
    fun getImgSlider() : Call<List<ImgSlider>>

    // for connecting with mvvm arch
    @GET("api/json/v1/1/search.php?s=margarita")
    suspend fun get(
    ) : CocktailSearchResponse


    // for direct connecting in activity or fragment
    @GET("api/json/v1/1/search.php?s=margarita")
    fun getCocktails() : Call<CocktailSearchResponse>

}