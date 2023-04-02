package by.nekhviadovich.store.repository;

import by.nekhviadovich.store.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}