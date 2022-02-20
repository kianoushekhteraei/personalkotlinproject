package andriod.kianoushekhteraei.kotlinproject.network.model

import com.google.gson.annotations.SerializedName

data class CocktailDto(

    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String,

    @SerializedName("strDrink")
    val strDrink: String,

    @SerializedName("strCategory")
    val strCategory: String,

    @SerializedName("strAlcoholic")
    val strAlcoholic: String,

    @SerializedName("strInstructions")
    val strInstructions: String,

    @SerializedName("strIngredient1")
    val strIngredient1: String,

    @SerializedName("strIngredient2")
    val strIngredient2: String,

    @SerializedName("strIngredient3")
    val strIngredient3: String,

    @SerializedName("strMeasure1")
    val strMeasure1: String,

    @SerializedName("strMeasure2")
    val strMeasure2: String,

    @SerializedName("strMeasure3")
    val strMeasure3: String,



    )