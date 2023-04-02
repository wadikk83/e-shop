package by.nekhviadovich.store.repository;

import by.nekhviadovich.store.entity.ERole;
import by.nekhviadovich.store.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(ERole name);
}