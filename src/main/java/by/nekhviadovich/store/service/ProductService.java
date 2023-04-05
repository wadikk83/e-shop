package by.nekhviadovich.store.service;


import by.nekhviadovich.store.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    ProductDTO create(ProductDTO dto);

    Page<ProductDTO> findAll(Pageable pageable);

    ProductDTO findById(Long id);

    ProductDTO update(Long id, ProductDTO dto);

    Boolean deleteById(Long id);

}
