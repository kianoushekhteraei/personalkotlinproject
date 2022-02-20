package andriod.kianoushekhteraei.kotlinproject.network.model

import andriod.kianoushekhteraei.kotlinproject.domain.model.Skills
import andriod.kianoushekhteraei.kotlinproject.domain.util.DomainMapper


class SkillsDtoMapper : DomainMapper<SkillsDto, Skills> {

    override fun mapToDomainModel(model: SkillsDto): Skills {
        return Skills(
            id = model.id,
            img_skill = model.img_skill,
            name_skill = model.name_skill,
        )
    }

    override fun mapFromDomainModel(domainModel: Skills): SkillsDto {
        return SkillsDto(
            id = domainModel.id,
            img_skill = domainModel.img_skill,
            name_skill = domainModel.name_skill,

        )
    }

    fun toDomainList(initial: List<SkillsDto>): List<Skills>{
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Skills>): List<SkillsDto>{
        return initial.map { mapFromDomainModel(it) }
    }
}
