package by.nekhviadovich.store.mapper;

import by.nekhviadovich.store.dto.ProductDTO;
import by.nekhviadovich.store.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        uses = {CategoryMapper.class,
                ProductAttributeMapper.class,
                ProductItemMapper.class})
public interface ProductMapper {

    @Mapping(target = "categories", ignore = true)
    Product toEntity(ProductDTO dto);

    ProductDTO toDto(Product entity);

    @Mapping(target = "productAttributes", ignore = true)
    @Mapping(target = "productItems", ignore = true)
    ProductDTO toDtoShort(Product entity);
}
