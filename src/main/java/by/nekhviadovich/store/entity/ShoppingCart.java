package by.nekhviadovich.store.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ShoppingCart extends BaseEntity {

    /*@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "shoppingCart")
    private User user;*/

    @OneToMany(
            mappedBy = "shoppingCart",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<CartItem> cartItems;

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public void clearItems() {
        cartItems.clear();
    }

    public int getItemCount() {
        return this.cartItems.size();
    }
}
