package by.nekhviadovich.store.controller;


import by.nekhviadovich.store.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    /*@PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add new user",
            description = "Allows you to create a new user")
    public UserDTO create(@RequestBody @Valid UserDTO dto) {
        return service.save(dto);
    }*/

    /*@GetMapping()
    @Operation(summary = "Getting list all users",
            description = "Allows you to get list all users")
    public Page<UserDto> getAll(@RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
                                @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) Integer limit) {
        return service.findAll(PageRequest.of(offset, limit));
    }*/

  /*  @GetMapping(value = "/{id}")
    @Operation(summary = "Getting user by ID",
            description = "Allows you to getting user by ID")
    public UserDto getById(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id) {
        return service.findById(id);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Updating user by ID",
            description = "Allows you to update user by ID")
    public UserDto update(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id,
                          @RequestBody @Valid UserDto entity) {
        entity.setId(id);
        return service.update(entity);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deleting user",
            description = "Allows you to delete user by ID")
    public void deleteById(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id) {
        service.deleteById(id);
    }*/
}
