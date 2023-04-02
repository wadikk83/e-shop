package by.nekhviadovich.store.service;

import by.nekhviadovich.store.entity.User;

import java.util.Map;

public interface JwtService {

    String extractUsername(String token);

    boolean isTokenValid(String token, User user);

    String generateToken(User user);

    String generateToken(Map<String, Object> extraClaims, User user);
}
