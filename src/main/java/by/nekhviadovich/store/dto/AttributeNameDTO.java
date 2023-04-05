package by.nekhviadovich.store.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AttributeNameDTO extends AbstractDTO {

    @NotBlank
    private String name;

}
