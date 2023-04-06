package by.nekhviadovich.store.service.impl;

import by.nekhviadovich.store.dto.OrderDTO;
import by.nekhviadovich.store.entity.Order;
import by.nekhviadovich.store.exception.EntityErrorType;
import by.nekhviadovich.store.exception.EntityException;
import by.nekhviadovich.store.mapper.OrderMapper;
import by.nekhviadovich.store.repository.OrderRepository;
import by.nekhviadovich.store.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.String.format;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository repository;

    private final OrderMapper mapper;

    public OrderServiceImpl(OrderRepository repository, OrderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public OrderDTO create(OrderDTO dto) {
        final Order newEntity = mapper.toEntity(dto);
        final Order saveEntity = repository.save(newEntity);
        return mapper.toDto(saveEntity);
    }

    @Override
    public Page<OrderDTO> findAll(Pageable pageable) {
        return repository
                .findAll(pageable)
                .map(mapper::toDto);
    }

    @Override
    public OrderDTO findById(Long id) {
        final Order entity = repository
                .findById(id)
                .orElseThrow(() -> new EntityException(format(EntityErrorType.ENTITY_NOT_FOUND, id)));
        return mapper.toDto(entity);
    }

    @Override
    public OrderDTO update(Long id, OrderDTO dto) {
        if (repository.findById(id).isPresent()) {
            dto.setId(id);
            Order entityToSave = mapper.toEntity(dto);
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
