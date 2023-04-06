package by.nekhviadovich.store.controller;

import by.nekhviadovich.store.dto.AttributeNameDTO;
import by.nekhviadovich.store.entity.sort.UserSort;
import by.nekhviadovich.store.service.AttributeNameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/attributes", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Attribute controller", description = "Attribute controller CRUD operations")
@SecurityRequirement(name = "JWT")
public class AttributeNameController {

    private final AttributeNameService service;

    public AttributeNameController(AttributeNameService service) {
        this.service = service;
    }

    @GetMapping()
    @Operation(summary = "Getting list all attribute name",
            description = "Allows you to get list all attribute names")
    public Page<AttributeNameDTO> getAll(@RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
                                         @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) Integer limit,
                                         @RequestParam(value = "sort") UserSort sort) {
        return service.findAll(PageRequest.of(offset, limit, sort.getSortValue()));
    }

    @PostMapping()
    @Operation(summary = "Create new attribute name",
            description = "Allows you to create new attribute name")
    public AttributeNameDTO create(@RequestBody @Valid AttributeNameDTO dto) {
        return service.create(dto);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Getting attribute name by ID",
            description = "Allows you to getting attribute name by ID")
    public AttributeNameDTO getById(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id) {
        return service.findById(id);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Updating attribute name by ID",
            description = "Allows you to update attribute name by ID")
    public AttributeNameDTO update(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id,
                                   @RequestBody @Valid AttributeNameDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deleting attribute name",
            description = "Allows you to delete attribute name by ID")
    public Boolean deleteById(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id) {
        return service.deleteById(id);
    }
}
