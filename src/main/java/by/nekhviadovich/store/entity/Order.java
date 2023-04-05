package by.nekhviadovich.store.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    private Timestamp orderDate;

    private String orderStatus;

    private BigDecimal orderTotal;

    @OneToMany(mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<ProductItem> productItems;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
