package andriod.kianoushekhteraei.kotlinproject.network.model

import andriod.kianoushekhteraei.kotlinproject.domain.model.Cocktail
import andriod.kianoushekhteraei.kotlinproject.domain.util.DomainMapper

class CocktailDtoMapper : DomainMapper<CocktailDto, Cocktail> {

    override fun mapToDomainModel(model: CocktailDto): Cocktail {
        return Cocktail(

            strDrink = model.strDrink,
            strDrinkThumb = model.strDrinkThumb,
            strCategory = model.strCategory,
            strAlcoholic = model.strAlcoholic,
            strInstructions = model.strInstructions,
            strIngredient1 = model.strIngredient1,
            strIngredient2 = model.strIngredient2,
            strIngredient3 = model.strIngredient3,
            strMeasure1 = model.strMeasure1,
            strMeasure2 = model.strMeasure2,
            strMeasure3 = model.strMeasure3,


            )
    }

    override fun mapFromDomainModel(domainModel: Cocktail): CocktailDto {
        return CocktailDto(

            strDrink = domainModel.strDrink,
            strDrinkThumb = domainModel.strDrinkThumb,
            strCategory = domainModel.strCategory,
            strAlcoholic = domainModel.strAlcoholic,
            strInstructions = domainModel.strInstructions,
            strIngredient1 = domainModel.strIngredient1,
            strIngredient2 = domainModel.strIngredient2,
            strIngredient3 = domainModel.strIngredient3,
            strMeasure1 = domainModel.strMeasure1,
            strMeasure2 = domainModel.strMeasure2,
            strMeasure3 = domainModel.strMeasure3,



        )
    }

    fun toDomainList(initial: List<CocktailDto>): List<Cocktail> {
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Cocktail>): List<CocktailDto> {
        return initial.map { mapFromDomainModel(it) }
    }
}