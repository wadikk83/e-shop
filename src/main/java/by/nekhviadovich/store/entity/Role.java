package by.nekhviadovich.store.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role extends BaseEntity implements GrantedAuthority {

    @Enumerated(EnumType.STRING)
    private ERole name;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;

    public Role(String name) {
        this.name = ERole.valueOf(name);
    }

    @Override
    public String getAuthority() {
        return name.toString();
    }
}
