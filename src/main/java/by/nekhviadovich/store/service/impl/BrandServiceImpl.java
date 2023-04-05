package by.nekhviadovich.store.service.impl;

import by.nekhviadovich.store.dto.BrandDTO;
import by.nekhviadovich.store.service.BrandService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {
    @Override
    public BrandDTO create(BrandDTO dto) {
        return null;
    }

    @Override
    public Page<BrandDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public BrandDTO findById(Long id) {
        return null;
    }

    @Override
    public BrandDTO update(Long id, BrandDTO dto) {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }
}
