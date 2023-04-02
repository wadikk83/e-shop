package by.nekhviadovich.store.repository;

import by.nekhviadovich.store.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}