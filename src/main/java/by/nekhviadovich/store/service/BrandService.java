package by.nekhviadovich.store.service;

import by.nekhviadovich.store.dto.BrandDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BrandService {

    BrandDTO create(BrandDTO dto);

    Page<BrandDTO> findAll(Pageable pageable);

    BrandDTO findById(Long id);

    BrandDTO update(Long id, BrandDTO dto);

    Boolean deleteById(Long id);
}
