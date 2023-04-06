package by.nekhviadovich.store.dto;

import lombok.Data;

@Data
public class ProductAttributeDTO extends AbstractDTO {

    private AttributeNameDTO attributeName;

    private String val;
}
