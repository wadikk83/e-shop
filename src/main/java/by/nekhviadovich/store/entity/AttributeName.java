package by.nekhviadovich.store.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "attribute_names")
public class AttributeName extends BaseEntity {

    @Column(unique = true)
    private @NotNull String name;

    @OneToMany(mappedBy = "attributeName",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<ProductAttribute> productAttributes = new ArrayList<>();


}
