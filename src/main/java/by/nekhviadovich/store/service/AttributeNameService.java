package by.nekhviadovich.store.service;

import by.nekhviadovich.store.dto.AttributeNameDTO;
import by.nekhviadovich.store.entity.AttributeName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AttributeNameService {

    AttributeNameDTO save(AttributeNameDTO attributeNameDTO);

    Page<AttributeNameDTO> findAll(Pageable pageable);

    AttributeName findById(Long id);

    /*D save(D dto);

    D update(D dto);

    D findById(Long id);

    Page<D> findAll(Pageable pageable);

    void deleteById(Long id);*/
}
