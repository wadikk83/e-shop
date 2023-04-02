package by.nekhviadovich.store.service;

import by.nekhviadovich.store.dto.UserDTO;
import by.nekhviadovich.store.dto.jwt.AuthenticationRequest;
import by.nekhviadovich.store.dto.jwt.AuthenticationResponse;
import by.nekhviadovich.store.entity.User;

public interface AuthenticationService {

    AuthenticationResponse authenticate(AuthenticationRequest request);

    AuthenticationResponse register(UserDTO userDTO);

    void revokeAllUserTokens(User user);

    void saveUserToken(User user, String jwtToken);
}
