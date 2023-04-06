package by.nekhviadovich.store.controller;

import by.nekhviadovich.store.dto.CategoryDTO;
import by.nekhviadovich.store.entity.sort.UserSort;
import by.nekhviadovich.store.service.CategoryService;
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
@RequestMapping(value = "api/category", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Category controller", description = "Category controller CRUD operations")
@SecurityRequirement(name = "JWT")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }


    @GetMapping()
    @Operation(summary = "Getting list all categories",
            description = "Allows you to get list all categories")
    public Page<CategoryDTO> getAll(@RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
                                    @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) Integer limit,
                                    @RequestParam(value = "sort") UserSort sort) {
        return service.findAll(PageRequest.of(offset, limit, sort.getSortValue()));
    }

    @PostMapping()
    @Operation(summary = "Create new category",
            description = "Allows you to create new category")
    public CategoryDTO create(@RequestBody @Valid CategoryDTO dto) {
        return service.create(dto);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Getting category by ID",
            description = "Allows you to getting category by ID")
    public CategoryDTO getById(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id) {
        return service.findById(id);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Updating category by ID",
            description = "Allows you to update category by ID")
    public CategoryDTO update(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id,
                              @RequestBody @Valid CategoryDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deleting category",
            description = "Allows you to delete category by ID")
    public Boolean deleteById(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id) {
        return service.deleteById(id);
    }
}
