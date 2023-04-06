package by.nekhviadovich.store.service.impl;

import by.nekhviadovich.store.dto.BrandDTO;
import by.nekhviadovich.store.entity.Brand;
import by.nekhviadovich.store.exception.EntityErrorType;
import by.nekhviadovich.store.exception.EntityException;
import by.nekhviadovich.store.mapper.BrandMapper;
import by.nekhviadovich.store.repository.BrandRepository;
import by.nekhviadovich.store.service.BrandService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    private final BrandRepository repository;

    private final BrandMapper mapper;

    public BrandServiceImpl(BrandRepository repository, BrandMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public BrandDTO create(BrandDTO dto) {
        final Brand newEntity = mapper.toEntity(dto);
        final Brand saveEntity = repository.save(newEntity);
        return mapper.toDto(saveEntity);
    }

    @Override
    public Page<BrandDTO> findAll(Pageable pageable) {
        return repository
                .findAll(pageable)
                .map(mapper::toDto);
    }

    @Override
    public BrandDTO findById(Long id) {
        final Brand entity = repository
                .findById(id)
                .orElseThrow(() -> new EntityException(format(EntityErrorType.ENTITY_NOT_FOUND, id)));
        return mapper.toDto(entity);
    }

    @Override
    public BrandDTO update(Long id, BrandDTO dto) {
        if (repository.findById(id).isPresent()) {
            dto.setId(id);
            Brand entityToSave = mapper.toEntity(dto);
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
