package by.nekhviadovich.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ProductAttribute extends BaseEntity {

    @ManyToOne()
    @JoinColumn(name = "attribute_name_id")
    private @NonNull AttributeName attributeName;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    private String value;
}
