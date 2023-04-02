package by.nekhviadovich.store.service;

import by.nekhviadovich.store.entity.ERole;
import by.nekhviadovich.store.entity.Role;

public interface RoleService {

    Role findByRoleName(ERole role);
}
