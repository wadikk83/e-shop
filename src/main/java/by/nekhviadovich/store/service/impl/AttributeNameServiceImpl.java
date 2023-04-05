package by.nekhviadovich.store.service.impl;

import by.nekhviadovich.store.dto.AttributeNameDTO;
import by.nekhviadovich.store.entity.AttributeName;
import by.nekhviadovich.store.mapper.AttributeNameMapper;
import by.nekhviadovich.store.repository.AttributeNameRepository;
import by.nekhviadovich.store.service.AttributeNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AttributeNameServiceImpl implements AttributeNameService {

    private final AttributeNameRepository repository;
    private final AttributeNameMapper mapper;

    @Override
    public AttributeNameDTO save(AttributeNameDTO attributeNameDTO) {
        final AttributeName saveEntity = repository.save(mapper.toEntity(attributeNameDTO));
        return mapper.toDto(saveEntity);
    }

    @Override
    public Page<AttributeNameDTO> findAll(Pageable pageable) {
        return repository
                .findAll(pageable)
                .map(mapper::toDto);
    }

    @Override
    public AttributeName findById(Long id) {
        return repository.getReferenceById(id);
    }
}
