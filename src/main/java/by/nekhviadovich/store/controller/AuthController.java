package by.nekhviadovich.store.controller;

import by.nekhviadovich.store.dto.UserDTO;
import by.nekhviadovich.store.dto.jwt.AuthenticationRequest;
import by.nekhviadovich.store.dto.jwt.AuthenticationResponse;
import by.nekhviadovich.store.service.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Authentication")
@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("register")
    public AuthenticationResponse register(@RequestBody @Valid UserDTO userDTO) {
        return authenticationService.register(userDTO);
    }

    @PostMapping("login")
    public AuthenticationResponse authenticate(@RequestBody @Valid AuthenticationRequest request) {
        return authenticationService.authenticate(request);
    }
}
