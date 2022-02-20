package andriod.kianoushekhteraei.kotlinproject.network.model

import com.google.gson.annotations.SerializedName

data class ProductDto(

    @SerializedName("id")
    var id: Int,

    @SerializedName("title")
    var title: String,


    @SerializedName("price")
    var price: Double,


    @SerializedName("category")
    var category: String,

    @SerializedName("description")
    var description: String,


    @SerializedName("image")
    var image: String,

)
