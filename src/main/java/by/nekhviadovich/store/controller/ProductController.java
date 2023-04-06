package by.nekhviadovich.store.controller;

import by.nekhviadovich.store.dto.ProductDTO;
import by.nekhviadovich.store.entity.sort.UserSort;
import by.nekhviadovich.store.service.ProductService;
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
@RequestMapping(value = "api/products", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Product controller", description = "Product controller CRUD operations")
@SecurityRequirement(name = "JWT")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService productService) {
        this.service = productService;
    }

    @GetMapping()
    @Operation(summary = "Getting list all products",
            description = "Allows you to get list all products")
    public Page<ProductDTO> getAll(@RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
                                   @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) Integer limit,
                                   @RequestParam(value = "sort") UserSort sort) {
        return service.findAll(PageRequest.of(offset, limit, sort.getSortValue()));
    }

    @GetMapping("/all")
    @Operation(summary = "Getting list all products",
            description = "Allows you to get list all products")
    public Page<ProductDTO> getAllWithLazy(@RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
                                   @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) Integer limit,
                                   @RequestParam(value = "sort") UserSort sort) {
        return service.findAllWithLazy(PageRequest.of(offset, limit, sort.getSortValue()));
    }

    @PostMapping()
    @Operation(summary = "Create new product",
            description = "Allows you to create new product")
    public ProductDTO create(@RequestBody @Valid ProductDTO dto) {
        return service.create(dto);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Getting product by ID",
            description = "Allows you to getting product by ID")
    public ProductDTO getById(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id) {
        return service.findById(id);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Updating product by ID",
            description = "Allows you to update product by ID")
    public ProductDTO update(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id,
                             @RequestBody @Valid ProductDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deleting product",
            description = "Allows you to delete product by ID")
    public Boolean deleteById(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id) {
        return service.deleteById(id);
    }
}
