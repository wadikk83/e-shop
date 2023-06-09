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
@Table(name = "categories")
public class Category extends BaseEntity {

    @NotNull
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Product> products = new ArrayList();

    @ManyToOne
    private Category parent; //ссылка на родителя

    //список дочерних категорий
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Category> childList;
}
