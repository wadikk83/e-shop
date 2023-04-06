package by.nekhviadovich.store.controller;

import by.nekhviadovich.store.dto.BrandDTO;
import by.nekhviadovich.store.entity.sort.UserSort;
import by.nekhviadovich.store.service.BrandService;
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
@RequestMapping(value = "api/brands", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Brand controller", description = "Brand controller CRUD operations")
@SecurityRequirement(name = "JWT")
public class BrandController {

    private final BrandService service;

    public BrandController(BrandService brandService) {
        this.service = brandService;
    }

    @GetMapping()
    @Operation(summary = "Getting list all brands",
            description = "Allows you to get list all brands")
    public Page<BrandDTO> getAll(@RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
                                 @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) Integer limit,
                                 @RequestParam(value = "sort") UserSort sort) {
        return service.findAll(PageRequest.of(offset, limit, sort.getSortValue()));
    }

    @PostMapping()
    @Operation(summary = "Create new brand",
            description = "Allows you to create new brand")
    public BrandDTO create(@RequestBody @Valid BrandDTO dto) {
        return service.create(dto);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Getting brand by ID",
            description = "Allows you to getting brand by ID")
    public BrandDTO getById(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id) {
        return service.findById(id);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Updating brand by ID",
            description = "Allows you to update brand by ID")
    public BrandDTO update(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id,
                           @RequestBody @Valid BrandDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deleting brand",
            description = "Allows you to delete brand by ID")
    public Boolean deleteById(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id) {
        return service.deleteById(id);
    }
}
