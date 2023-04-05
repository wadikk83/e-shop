package by.nekhviadovich.store.service.impl;

import by.nekhviadovich.store.dto.ProductDTO;
import by.nekhviadovich.store.entity.Product;
import by.nekhviadovich.store.exception.EntityErrorType;
import by.nekhviadovich.store.exception.EntityException;
import by.nekhviadovich.store.mapper.ProductMapper;
import by.nekhviadovich.store.repository.ProductRepository;
import by.nekhviadovich.store.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO create(ProductDTO dto) {
        final Product newProduct = productMapper.toEntity(dto);
        final Product saveProduct = productRepository.save(newProduct);
        return productMapper.toDto(saveProduct);
    }

    @Override
    public Page<ProductDTO> findAll(Pageable pageable) {
        return productRepository
                .findAll(pageable)
                .map(productMapper::toDto);
    }

    @Override
    public ProductDTO findById(Long id) {
        final Product product = productRepository
                .findById(id)
                .orElseThrow(() -> new EntityException(format(EntityErrorType.ENTITY_NOT_FOUND, id)));
        return productMapper.toDto(product);
    }

    @Override
    public ProductDTO update(Long id, ProductDTO dto) {
        if (productRepository.findById(id).isPresent()) {
            dto.setId(id);
            Product entityToSave = productMapper.toEntity(dto);
            return productMapper.toDto(productRepository.save(entityToSave));
        } else {
            throw new EntityException(String.format(EntityErrorType.ENTITY_NOT_UPDATED, id));
        }
    }

    @Override
    public Boolean deleteById(Long id) {
        findById(id);
        productRepository.deleteById(id);
        return productRepository.findById(id).isEmpty();
    }
}
