package by.nekhviadovich.store.dto;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDTO extends AbstractDTO {

    private String name;

    private String parent;

    private List<String> childList;
}
