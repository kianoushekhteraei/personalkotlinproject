package andriod.kianoushekhteraei.kotlinproject.network.base

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object ApiClient {

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(8, TimeUnit.SECONDS)
        .writeTimeout(5, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS)
        .build()

    private val retrofitProduct = Retrofit.Builder()
        .baseUrl("https://fakestoreapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()


    private val retrofitDrink = Retrofit.Builder()
        .baseUrl("https://www.thecocktaildb.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    private val retrofitSlider = Retrofit.Builder()
        .baseUrl("https://techcrunch.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()



    fun <T> buildServiceProduct(service: Class<T>): T {
        return retrofitProduct.create(service)
    }

    fun <T> buildServiceDrink(service: Class<T>): T {
        return retrofitDrink.create(service)
    }

    fun <T> buildServiceSlider(service: Class<T>): T {
        return retrofitSlider.create(service)
    }
}