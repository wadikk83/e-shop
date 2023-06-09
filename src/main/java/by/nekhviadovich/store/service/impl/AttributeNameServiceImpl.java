package by.nekhviadovich.store.service.impl;

import by.nekhviadovich.store.dto.AttributeNameDTO;
import by.nekhviadovich.store.entity.AttributeName;
import by.nekhviadovich.store.exception.EntityErrorType;
import by.nekhviadovich.store.exception.EntityException;
import by.nekhviadovich.store.mapper.AttributeNameMapper;
import by.nekhviadovich.store.repository.AttributeNameRepository;
import by.nekhviadovich.store.service.AttributeNameService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.String.format;

@Service
@Transactional
public class AttributeNameServiceImpl implements AttributeNameService {

    private final AttributeNameRepository repository;

    private final AttributeNameMapper mapper;

    public AttributeNameServiceImpl(AttributeNameRepository repository, AttributeNameMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public AttributeNameDTO create(AttributeNameDTO dto) {
        final AttributeName newEntity = mapper.toEntity(dto);
        final AttributeName saveEntity = repository.save(newEntity);
        return mapper.toDto(saveEntity);
    }

    @Override
    public Page<AttributeNameDTO> findAll(Pageable pageable) {
        return repository
                .findAll(pageable)
                .map(mapper::toDto);
    }

    @Override
    public AttributeNameDTO findById(Long id) {
        final AttributeName entity = repository
                .findById(id)
                .orElseThrow(() -> new EntityException(format(EntityErrorType.ENTITY_NOT_FOUND, id)));
        return mapper.toDto(entity);
    }

    @Override
    public AttributeNameDTO update(Long id, AttributeNameDTO dto) {
        if (repository.findById(id).isPresent()) {
            dto.setId(id);
            AttributeName entityToSave = mapper.toEntity(dto);
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
