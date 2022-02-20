package andriod.kianoushekhteraei.kotlinproject.network.model

import andriod.kianoushekhteraei.kotlinproject.domain.model.Product
import andriod.kianoushekhteraei.kotlinproject.domain.util.DomainMapper


class ProductDtoMapper  : DomainMapper<ProductDto, Product> {

    override fun mapToDomainModel(model: ProductDto): Product {
        return Product(
            id = model.id,
            title = model.title,
            price = model.price,
            category = model.category,
            description = model.description,
            image = model.image
        )
    }

    override fun mapFromDomainModel(domainModel: Product): ProductDto {
        return ProductDto(
            id = domainModel.id,
            title = domainModel.title,
            price = domainModel.price,
            category = domainModel.category,
            description = domainModel.description,
            image = domainModel.image
        )
    }

    fun toDomainList(initial: List<ProductDto>): List<Product>{
        return initial.map { mapToDomainModel(it) }
    }

    fun fromDomainList(initial: List<Product>): List<ProductDto>{
        return initial.map { mapFromDomainModel(it) }
    }
}


