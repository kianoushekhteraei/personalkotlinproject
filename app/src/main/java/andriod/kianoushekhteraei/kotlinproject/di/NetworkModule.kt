package andriod.kianoushekhteraei.kotlinproject.di

import andriod.kianoushekhteraei.kotlinproject.network.base.CategoryFrgServices
import andriod.kianoushekhteraei.kotlinproject.network.base.HomeFrgServices
import andriod.kianoushekhteraei.kotlinproject.network.base.ShopFrgServices
import andriod.kianoushekhteraei.kotlinproject.network.model.CocktailDtoMapper
import andriod.kianoushekhteraei.kotlinproject.network.model.ProductDtoMapper
import andriod.kianoushekhteraei.kotlinproject.network.model.RecipeDtoMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRecipeMapper(): RecipeDtoMapper {
        return RecipeDtoMapper()
    }

    @Singleton
    @Provides
    fun provideProductsMapper(): ProductDtoMapper {
        return ProductDtoMapper()
    }

    @Singleton
    @Provides
    fun provideCocktailMapper(): CocktailDtoMapper {
        return CocktailDtoMapper()
    }


    @Singleton
    @Provides
    fun provideRecipeService(): ShopFrgServices {
        return Retrofit.Builder()
            .baseUrl("https://food2fork.ca/api/recipe/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ShopFrgServices::class.java)
    }


    @Singleton
    @Provides
    fun provideProductService(): CategoryFrgServices {
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(CategoryFrgServices::class.java)
    }

    @Singleton
    @Provides
    fun provideCocktailService(): HomeFrgServices {
        return Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(HomeFrgServices::class.java)
    }

    @Singleton
    @Provides
    @Named("auth_token")
    fun provideAuthToken(): String{
        return "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
    }


}