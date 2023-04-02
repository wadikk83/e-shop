package by.nekhviadovich.store.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ERole {
    ROLE_USER,
    ROLE_MANAGER,
    ROLE_ADMIN
}
