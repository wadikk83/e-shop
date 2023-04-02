package by.nekhviadovich.store.dto.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {

    private final String type = "Bearer";
    private String token;
}
