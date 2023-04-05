package by.nekhviadovich.store.repository;

import by.nekhviadovich.store.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByAuthority(String roleName);
}