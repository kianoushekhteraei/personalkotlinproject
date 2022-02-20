package andriod.kianoushekhteraei.kotlinproject.network.response

import andriod.kianoushekhteraei.kotlinproject.network.model.CocktailDto
import com.google.gson.annotations.SerializedName


class CocktailSearchResponse(


    @SerializedName("drinks")
    var drinks: List<CocktailDto>,

    )