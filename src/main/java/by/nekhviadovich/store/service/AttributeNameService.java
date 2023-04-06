package by.nekhviadovich.store.service;

import by.nekhviadovich.store.dto.AttributeNameDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AttributeNameService {

    AttributeNameDTO create(AttributeNameDTO dto);

    Page<AttributeNameDTO> findAll(Pageable pageable);

    AttributeNameDTO findById(Long id);

    AttributeNameDTO update(Long id, AttributeNameDTO dto);

    Boolean deleteById(Long id);
}
