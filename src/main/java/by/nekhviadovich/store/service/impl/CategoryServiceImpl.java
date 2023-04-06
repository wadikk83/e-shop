package by.nekhviadovich.store.service.impl;

import by.nekhviadovich.store.dto.CategoryDTO;
import by.nekhviadovich.store.entity.Category;
import by.nekhviadovich.store.exception.EntityErrorType;
import by.nekhviadovich.store.exception.EntityException;
import by.nekhviadovich.store.mapper.CategoryMapper;
import by.nekhviadovich.store.repository.CategoryRepository;
import by.nekhviadovich.store.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.String.format;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    private final CategoryMapper mapper;

    public CategoryServiceImpl(CategoryRepository repository, CategoryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CategoryDTO create(CategoryDTO dto) {
        final Category newEntity = mapper.toEntity(dto, repository);
        final Category saveEntity = repository.save(newEntity);
        return mapper.toDto(saveEntity);
    }

    @Override
    public Page<CategoryDTO> findAll(Pageable pageable) {
        return repository
                .findAll(pageable)
                .map(mapper::toDto);
    }

    @Override
    public CategoryDTO findById(Long id) {
        final Category entity = repository
                .findById(id)
                .orElseThrow(() -> new EntityException(format(EntityErrorType.ENTITY_NOT_FOUND, id)));
        return mapper.toDto(entity);
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO dto) {
        if (repository.findById(id).isPresent()) {
            dto.setId(id);
            Category entityToSave = mapper.toEntity(dto,repository);
            return mapper.toDto(repository.save(entityToSave));
        } else {
            throw new EntityException(String.format(EntityErrorType.ENTITY_NOT_UPDATED, id));
        }
    }

    @Override
    public Boolean deleteById(Long id) {
        findById(id);
        repository.deleteById(id);
        return repository.findById(id).isEmpty();
    }

}
