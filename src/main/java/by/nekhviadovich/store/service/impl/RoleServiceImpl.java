package by.nekhviadovich.store.service.impl;

import by.nekhviadovich.store.entity.Role;
import by.nekhviadovich.store.repository.RoleRepository;
import by.nekhviadovich.store.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;


    @Override
    public Role findByRoleName(String roleName) {
        return roleRepository.findByAuthority(roleName);
    }
}
