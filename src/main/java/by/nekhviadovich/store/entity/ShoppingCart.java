package by.nekhviadovich.store.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ShoppingCart extends BaseEntity {

    @OneToOne(mappedBy = "shoppingCart")
    private User user;

    @OneToMany(
            mappedBy = "shoppingCart",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<ProductItem> productItems;

    public boolean isEmpty() {
        return productItems.isEmpty();
    }

    public void clearItems() {
        productItems.clear();
    }

    public int getItemCount() {
        return this.productItems.size();
    }
}
