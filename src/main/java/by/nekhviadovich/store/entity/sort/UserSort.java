package by.nekhviadovich.store.entity.sort;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;

@Getter
@RequiredArgsConstructor
public enum UserSort {

    ID_ASC(Sort.by(Sort.Direction.ASC, "id")),
    ID_DESC(Sort.by(Sort.Direction.DESC, "id")),
    USERNAME_ASC(Sort.by(Sort.Direction.ASC, "username")),
    USERNAME_DESC(Sort.by(Sort.Direction.DESC, "username"));

    private final Sort sortValue;
}
