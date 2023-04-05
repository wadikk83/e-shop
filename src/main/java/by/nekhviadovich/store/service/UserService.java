package by.nekhviadovich.store.service;

import by.nekhviadovich.store.dto.UserDTO;
import by.nekhviadovich.store.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDTO findByUsername(String username);

    User create(UserDTO dto);

    Page<UserDTO> findAll(Pageable pageable);

    UserDTO findById(Long id);

    UserDTO update(Long id, UserDTO dto);

    Boolean deleteById(Long id);
}
