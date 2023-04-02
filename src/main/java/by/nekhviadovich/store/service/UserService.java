package by.nekhviadovich.store.service;

import by.nekhviadovich.store.dto.UserDTO;
import by.nekhviadovich.store.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {

    Optional<UserDTO> findByUsername(String username);

    User create(UserDTO userDTO);

    Optional<UserDTO> findByEmail(String email);

    Page<UserDTO> findAll(Pageable pageable);
}
