package by.nekhviadovich.store.repository;

import by.nekhviadovich.store.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    @EntityGraph(value = "productAttributes-graph")
    @Query("select p from Product p")
    Page<Product> findAllFetchProductAttributes(Pageable pageable);

}