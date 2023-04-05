package by.nekhviadovich.store.controller;


import by.nekhviadovich.store.dto.UserDTO;
import by.nekhviadovich.store.entity.Role;
import by.nekhviadovich.store.entity.sort.UserSort;
import by.nekhviadovich.store.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "User controller", description = "User controller CRUD operations")
@SecurityRequirement(name = "JWT")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @RolesAllowed(Role.ADMIN)
    @GetMapping()
    @Operation(summary = "Getting list all users",
            description = "Allows you to get list all users")
    public Page<UserDTO> getAll(@RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
                                @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) Integer limit,
                                @RequestParam(value = "sort") UserSort sort) {
        return service.findAll(PageRequest.of(offset, limit, sort.getSortValue()));
    }

    @RolesAllowed(Role.USER)
    @GetMapping(value = "/{id}")
    @Operation(summary = "Getting user by ID",
            description = "Allows you to getting user by ID")
    public UserDTO getById(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id) {
        return service.findById(id);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Updating user by ID",
            description = "Allows you to update user by ID")
    public UserDTO update(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id,
                          @RequestBody @Valid UserDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deleting user",
            description = "Allows you to delete user by ID")
    public Boolean deleteById(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id) {
        return service.deleteById(id);
    }
}
