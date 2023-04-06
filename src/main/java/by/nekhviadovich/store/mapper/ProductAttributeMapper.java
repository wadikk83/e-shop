package by.nekhviadovich.store.mapper;


import by.nekhviadovich.store.dto.ProductAttributeDTO;
import by.nekhviadovich.store.entity.ProductAttribute;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AttributeNameMapper.class})
public interface ProductAttributeMapper {

    ProductAttributeDTO toDto(ProductAttribute productAttribute);

    ProductAttribute toEntity(ProductAttributeDTO productAttributeDTO);
}
