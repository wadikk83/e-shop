package by.nekhviadovich.store.mapper;

import by.nekhviadovich.store.dto.ProductItemDTO;
import by.nekhviadovich.store.entity.ProductItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductItemMapper {

    ProductItem toEntity(ProductItemDTO dto);

    ProductItemDTO toDto(ProductItem entity);
}
