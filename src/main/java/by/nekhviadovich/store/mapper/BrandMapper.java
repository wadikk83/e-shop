package by.nekhviadovich.store.mapper;

import by.nekhviadovich.store.dto.BrandDTO;
import by.nekhviadovich.store.entity.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    Brand toEntity(BrandDTO dto);

    BrandDTO toDto(Brand entity);
}
