package by.nekhviadovich.store.mapper;

import by.nekhviadovich.store.dto.ProductDTO;
import by.nekhviadovich.store.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductDTO dto);

    ProductDTO toDto(Product entity);
}
