package by.nekhviadovich.store.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO extends AbstractDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String firstName;

    private String lastName;

    @NotBlank
    @Email
    private String email;

    private Set<String> authorities;
}
