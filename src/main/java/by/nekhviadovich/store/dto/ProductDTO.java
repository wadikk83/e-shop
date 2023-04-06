package by.nekhviadovich.store.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDTO extends AbstractDTO {

    private String name;

    private int stock;

    private double price;

    private String picture;

    private BrandDTO brand;

    private List<CategoryDTO> categories;

    private List<ProductAttributeDTO> productAttributes;

    private List<ProductItemDTO> productItems;
}
