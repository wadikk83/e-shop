package by.nekhviadovich.store.repository;

import by.nekhviadovich.store.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}