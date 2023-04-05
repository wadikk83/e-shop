package by.nekhviadovich.store.mapper;

import by.nekhviadovich.store.dto.ShoppingCardDTO;
import by.nekhviadovich.store.entity.ShoppingCart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShoppingCardMapper {

    ShoppingCart toEntity(ShoppingCardDTO dto);

    ShoppingCardDTO toDto(ShoppingCart entity);
}
