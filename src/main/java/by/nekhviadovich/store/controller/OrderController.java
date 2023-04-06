package by.nekhviadovich.store.controller;

import by.nekhviadovich.store.dto.OrderDTO;
import by.nekhviadovich.store.entity.sort.UserSort;
import by.nekhviadovich.store.service.OrderService;
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
@RequestMapping(value = "api/orders", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Order controller", description = "Order controller CRUD operations")
@SecurityRequirement(name = "JWT")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping()
    @Operation(summary = "Getting list all orders",
            description = "Allows you to get list all orders")
    public Page<OrderDTO> getAll(@RequestParam(value = "offset", defaultValue = "0") @Min(0) Integer offset,
                                 @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) Integer limit,
                                 @RequestParam(value = "sort") UserSort sort) {
        return service.findAll(PageRequest.of(offset, limit, sort.getSortValue()));
    }

    @PostMapping()
    @Operation(summary = "Create new order",
            description = "Allows you to create new order")
    public OrderDTO create(@RequestBody @Valid OrderDTO dto) {
        return service.create(dto);
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Getting order by ID",
            description = "Allows you to getting order by ID")
    public OrderDTO getById(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id) {
        return service.findById(id);
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Updating order by ID",
            description = "Allows you to update order by ID")
    public OrderDTO update(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id,
                           @RequestBody @Valid OrderDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deleting order",
            description = "Allows you to delete order by ID")
    public Boolean deleteById(@PathVariable(name = "id") @Min(1) @Max(Long.MAX_VALUE) Long id) {
        return service.deleteById(id);
    }
}
