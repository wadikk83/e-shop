package by.nekhviadovich.store.mapper;

import by.nekhviadovich.store.dto.CategoryDTO;
import by.nekhviadovich.store.entity.Category;
import by.nekhviadovich.store.repository.CategoryRepository;
import org.mapstruct.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings(value = {
            @Mapping(target = "parent", ignore = true),
            @Mapping(target = "childList", ignore = true)})
    Category toEntity(CategoryDTO dto, @Context CategoryRepository repo);

    @Mappings(value = {
            @Mapping(source = "parent", target = "parent", qualifiedByName = "parentToString"),
            @Mapping(source = "childList", target = "childList", qualifiedByName = "childListToStringList")})
    CategoryDTO toDto(Category entity);

    @AfterMapping
    default void toEntity(@MappingTarget Category category, CategoryDTO dto, @Context CategoryRepository repo) {
        if (dto.getParent() != null) {
            category.setParent(repo.findByName(dto.getParent()));
        }
        if (category.getChildList() != null) {
            category.setChildList(
                    dto.getChildList()
                            .stream()
                            .map(repo::findByName)
                            .collect(Collectors.toList())
            );
        }
    }

    @Named("parentToString")
    default String parentEntityToDto(Category category) {
        if (category != null) {
            return category.getName();
        }
        return null;
    }

    @Named("childListToStringList")
    default List<String> childListToStringList(List<Category> childList) {
        if (childList != null) {
            return childList.stream()
                    .map(Category::getName)
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
