package by.nekhviadovich.store.service.impl;

import by.nekhviadovich.store.dto.UserDTO;
import by.nekhviadovich.store.entity.ERole;
import by.nekhviadovich.store.entity.Role;
import by.nekhviadovich.store.entity.User;
import by.nekhviadovich.store.mapper.UserMapper;
import by.nekhviadovich.store.repository.RoleRepository;
import by.nekhviadovich.store.repository.UserRepository;
import by.nekhviadovich.store.service.UserService;
import jakarta.validation.ValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static java.lang.String.format;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           UserMapper userMapper,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException(format("User with username - %s, not found", username)));
    }

    @Override
    public Optional<UserDTO> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public User create(UserDTO userDTO) {

        if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
            throw new ValidationException("There is an account with that username: "
                    + userDTO.getUsername());
        }

        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new ValidationException("There is an account with that email address: "
                    + userDTO.getEmail());
        }

        User user = userMapper.toEntity(userDTO);
        final Role userRole = roleRepository.findByName(ERole.ROLE_USER);
        user.setAuthorities(new HashSet<>(Set.of(userRole)));
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Optional<UserDTO> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Page<UserDTO> findAll(Pageable pageable) {
        return userRepository
                .findAll(pageable)
                .map(userMapper::toDto);
    }

}

