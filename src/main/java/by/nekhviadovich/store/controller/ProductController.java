package by.nekhviadovich.store.controller;

import by.nekhviadovich.store.dto.ProductDTO;
import by.nekhviadovich.store.entity.sort.UserSort;
import by.nekhviadovich.store.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/products", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Product controller", description = "Product controller CRUD operations")
@SecurityRequirement(name = "JWT")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    @Operation(summary = "Getting list all products",
            description = "Allows you to get list all products")
    public Page<ProductDTO> getAll(@RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
                                   @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) Integer limit,
                                   @RequestParam(value = "sort") UserSort sort) {
        return productService.findAll(PageRequest.of(offset, limit, sort.getSortValue()));
    }
}
