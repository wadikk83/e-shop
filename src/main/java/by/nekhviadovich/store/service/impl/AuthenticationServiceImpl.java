package by.nekhviadovich.store.service.impl;

import by.nekhviadovich.store.dto.UserDTO;
import by.nekhviadovich.store.dto.jwt.AuthenticationRequest;
import by.nekhviadovich.store.dto.jwt.AuthenticationResponse;
import by.nekhviadovich.store.entity.ETokenType;
import by.nekhviadovich.store.entity.Token;
import by.nekhviadovich.store.entity.User;
import by.nekhviadovich.store.repository.TokenRepository;
import by.nekhviadovich.store.repository.UserRepository;
import by.nekhviadovich.store.service.AuthenticationService;
import by.nekhviadovich.store.service.JwtService;
import by.nekhviadovich.store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final TokenRepository tokenRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        final User user = (User) userService.loadUserByUsername(request.getUsername());

        final String jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse register(UserDTO userDTO) {
        final User newUser = userService.create(userDTO);

        var jwtToken = jwtService.generateToken(newUser);
        saveUserToken(newUser, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUserId(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    @Override
    public void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(ETokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }
}
