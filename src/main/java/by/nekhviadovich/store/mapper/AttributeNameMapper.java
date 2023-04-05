package by.nekhviadovich.store.mapper;

import by.nekhviadovich.store.dto.AttributeNameDTO;
import by.nekhviadovich.store.entity.AttributeName;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttributeNameMapper {

    AttributeName toEntity(AttributeNameDTO attributeNameDTO);

    AttributeNameDTO toDto(AttributeName attributeName);
}
