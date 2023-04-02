package by.nekhviadovich.store.repository;

import by.nekhviadovich.store.entity.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Long> {
}