package by.nekhviadovich.store.mapper;

import by.nekhviadovich.store.dto.OrderDTO;
import by.nekhviadovich.store.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toEntity(OrderDTO dto);

    OrderDTO toDto(Order entity);
}
