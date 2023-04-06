package by.nekhviadovich.store.service;

import by.nekhviadovich.store.dto.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    CategoryDTO create(CategoryDTO dto);

    Page<CategoryDTO> findAll(Pageable pageable);

    CategoryDTO findById(Long id);

    CategoryDTO update(Long id, CategoryDTO dto);

    Boolean deleteById(Long id);
}
