package by.nekhviadovich.store.repository;

import by.nekhviadovich.store.entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}