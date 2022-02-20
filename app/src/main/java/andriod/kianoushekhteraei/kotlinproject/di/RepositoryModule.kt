package andriod.kianoushekhteraei.kotlinproject.di

import andriod.kianoushekhteraei.kotlinproject.network.base.CategoryFrgServices
import andriod.kianoushekhteraei.kotlinproject.network.base.HomeFrgServices
import andriod.kianoushekhteraei.kotlinproject.network.base.ShopFrgServices
import andriod.kianoushekhteraei.kotlinproject.network.model.CocktailDtoMapper
import andriod.kianoushekhteraei.kotlinproject.network.model.ProductDtoMapper
import andriod.kianoushekhteraei.kotlinproject.network.model.RecipeDtoMapper
import andriod.kianoushekhteraei.kotlinproject.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        shopFrgServices: ShopFrgServices,
        recipeMapper: RecipeDtoMapper,
    ): RecipeRepository {
        return RecipeRepoImpl(
            shopFrgServices = shopFrgServices,
            mapper = recipeMapper
        )
    }

    @Singleton
    @Provides
    fun provideProductRepository(
        categoryFrgServices: CategoryFrgServices,
        mapper : ProductDtoMapper
    ): ProductRepository {
        return ProductRepoImpl(

            categoryFrgServices = categoryFrgServices,
            mapper = mapper

        )
    }

    @Singleton
    @Provides
    fun provideCocktailRepository(
        homeFrgServices: HomeFrgServices,
        mapper: CocktailDtoMapper
    ): CocktailRepository {
        return CocktailRepoImpl(

            homeFrgServices = homeFrgServices,
            mapper = mapper

        )
    }
}


