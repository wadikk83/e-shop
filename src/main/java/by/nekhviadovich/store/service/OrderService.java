package by.nekhviadovich.store.service;

import by.nekhviadovich.store.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    OrderDTO create(OrderDTO dto);

    Page<OrderDTO> findAll(Pageable pageable);

    OrderDTO findById(Long id);

    OrderDTO update(Long id, OrderDTO dto);

    Boolean deleteById(Long id);
}
