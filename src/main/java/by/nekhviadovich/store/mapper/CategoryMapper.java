package by.nekhviadovich.store.mapper;

import by.nekhviadovich.store.dto.CategoryDTO;
import by.nekhviadovich.store.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(CategoryDTO dto);

    CategoryDTO toDto(Category entity);
}
