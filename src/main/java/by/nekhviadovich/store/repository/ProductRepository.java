package by.nekhviadovich.store.repository;

import by.nekhviadovich.store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}