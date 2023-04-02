package by.nekhviadovich.store.dto.jwt;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class AuthenticationRequest {

    private String username;
    private String password;

}
