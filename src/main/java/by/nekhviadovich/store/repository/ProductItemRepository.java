package by.nekhviadovich.store.repository;

import by.nekhviadovich.store.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}