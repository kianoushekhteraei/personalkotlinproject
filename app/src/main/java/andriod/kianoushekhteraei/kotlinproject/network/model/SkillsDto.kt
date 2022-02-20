package andriod.kianoushekhteraei.kotlinproject.network.model

import com.google.gson.annotations.SerializedName


data class SkillsDto(

    @SerializedName("id")
    var id: Int,

    @SerializedName("img_skill")
    var img_skill: Int,

    @SerializedName("name_skill")
    var name_skill: String,

)